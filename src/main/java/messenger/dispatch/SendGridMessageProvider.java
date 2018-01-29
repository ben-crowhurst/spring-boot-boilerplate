package messenger.dispatch;

import org.springframework.stereotype.*;

import messenger.data.*;

@Service
public class SendGridMessageProvider implements MessageProvider {
    @Override
    public void send(Message value) {
        System.out.println("hello from sendgrid.");
    }
}