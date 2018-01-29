package messenger.dispatch;

import org.springframework.stereotype.*;

import messenger.data.*;

@Service
public class MailGunMessageProvider implements MessageProvider {
    @Override
    public void send(Message message) {
        throw new MessageProviderException("mailgun", "Not Implemented");
    }
}