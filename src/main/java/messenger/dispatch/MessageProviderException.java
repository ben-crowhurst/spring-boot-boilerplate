package messenger.dispatch;

class MessageProviderException extends RuntimeException {
    private final String providerName;
    public String getProviderName() {
        return providerName;
    }

    public MessageProviderException(String providerName, String errorMessage) {
        super(errorMessage);
        this.providerName = providerName;
    }
}