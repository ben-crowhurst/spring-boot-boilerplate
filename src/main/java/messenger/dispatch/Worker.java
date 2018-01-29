package messenger.dispatch;

import java.util.*;
import java.util.concurrent.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

import messenger.data.*;

@Service
public class Worker implements Runnable {
    @Autowired
    private List<MessageProvider> messageProviders;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Autowired
    public void setup(@Value("${dispatch.delay:5000}") long delay, @Value("${dispatch.initialDelay:10000}") long initialDelay) {
        int corePoolSize = 1;
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(corePoolSize);
        executor.scheduleWithFixedDelay(this, initialDelay, delay, TimeUnit.MILLISECONDS);
    }

    public void run() {
        List<Message> messages = messageRepository.findByStatus("pending");

        for (MessageProvider provider : messageProviders) {
            provider.send(null);
        }
    }
}