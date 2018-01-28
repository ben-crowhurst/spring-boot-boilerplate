package messenger.dispatch;

import java.util.concurrent.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

@Service
public class Dispatch implements Runnable {
    @Autowired
    public void setup(@Value("${dispatch.initialDelay:1500}") long initialDelay, @Value("${dispatch.delay:1000}") long delay) {
        int corePoolSize = 1;
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(corePoolSize);
        executor.scheduleWithFixedDelay(new Dispatch(), initialDelay, delay, TimeUnit.MILLISECONDS);
    }

    public void run() {
        System.out.println("Running dispatch...");
    }

    private Dispatch() {
        return;
    }
}