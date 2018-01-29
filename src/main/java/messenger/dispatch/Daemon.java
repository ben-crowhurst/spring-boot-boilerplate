package messenger.dispatch;

import java.util.*;
import java.util.concurrent.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

import messenger.data.*;

@Service
public class Daemon implements Runnable {
    private static List<MessageProvider> providers;
    @Autowired
    public void setProviders(List<MessageProvider> values) {
        providers = values;
    }

    @Autowired
    public void setup(@Value("${dispatch.delay:5000}") long delay, @Value("${dispatch.initialDelay:10000}") long initialDelay) {
        int corePoolSize = 1;
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(corePoolSize);
        executor.scheduleWithFixedDelay(new Daemon(), initialDelay, delay, TimeUnit.MILLISECONDS);
    }

    public void run() {
        for (MessageProvider provider : providers) {
            provider.send(null);
        }
    }
}