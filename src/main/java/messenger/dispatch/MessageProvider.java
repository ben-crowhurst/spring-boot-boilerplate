package messenger.dispatch;

import messenger.data.*;

public interface MessageProvider {
    public void send(Message value);
}