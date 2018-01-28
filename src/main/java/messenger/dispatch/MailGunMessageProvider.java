package messenger.dispatch;

import messenger.service.*;
import org.springframework.stereotype.*;

@Service
public class MailGunMessageProvider implements MessageProvider {
    @Override
    public void send(Message value) {
        System.out.println("hello from mailgun.");
    }
}