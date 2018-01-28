package messenger.dispatch;

import messenger.service.*;

public interface MessageProvider {
    public void send(Message value);
}