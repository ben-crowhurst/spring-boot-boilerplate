package messenger.dispatch;

import messenger.service.*;
import org.springframework.stereotype.*;

@Service
public class SendGridMessageProvider implements MessageProvider {
    @Override
    public void send(Message value) {
        System.out.println("hello from sendgrid.");
    }
}