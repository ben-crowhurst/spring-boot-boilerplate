package messenger.dispatch;

class MessageProviderException extends RuntimeException {
    public MessageProviderException() {
        return;
    }

    public MessageProviderException(String message) {
        super(message);
    }
}