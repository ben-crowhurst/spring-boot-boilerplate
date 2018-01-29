package messenger.dispatch;

import java.util.*;
import java.util.concurrent.*;
import javax.annotation.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

import messenger.data.*;

@Service
public class Worker implements Runnable {
    private static final Logger logger = Logger.getLogger(Worker.class);

    private long delay = 0;
    private long initialDelay = 0;
    private long maxDeliveryAttempts = 0;

    @Autowired
    public Worker(
        @Value("${dispatch.delay:5000}") long delay,
        @Value("${dispatch.initialDelay:10000}") long initialDelay,
        @Value("${dispatch.maxDeliveryAttempts:3}") long maxDeliveryAttempts
    ) {
        this.delay = delay;
        this.initialDelay = initialDelay;
        this.maxDeliveryAttempts = maxDeliveryAttempts;
    }

    @PostConstruct
    public void setup() {
        int corePoolSize = 1;
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(corePoolSize);
        executor.scheduleWithFixedDelay(this, initialDelay, delay, TimeUnit.MILLISECONDS);
    }

    @Autowired
    private MessageRepository messageRepository;

    public void run() {
        for (Message message : messageRepository.findByStatus("pending")) {
            send(message);
        }
    }

    @Autowired
    private List<MessageProvider> messageProviders;

    public void send(Message message) {
        for (MessageProvider provider : messageProviders) {
            try {
                provider.send(message);
                message.setStatus("delivered");
                messageRepository.save(message);
                return;
            } catch (MessageProviderException mpe) {
                logger.error("Message delivery failure.", mpe);
            }
        }

        long deliveryAttempts = message.getDeliveryAttempts() + 1;
        message.setDeliveryAttempts(deliveryAttempts);

        if (deliveryAttempts >= maxDeliveryAttempts) {
            message.setStatus("failed");
        }

        messageRepository.save(message);
    }
}