package messengerd;

import java.time.*;

public class Message {
    public Message() {
        timestamp = Instant.now().getEpochSecond();
        status = "pending";
        key = "";
        content = "";
        from = "";
        to = new String[0];
        cc = new String[0];
        bcc = new String[0];
    }

    private final long timestamp;
    public long getCreatedTimestamp() {
        return timestamp;
    }

    private String status;
    public String getStatus() {
        return status;
    }

    private String key;
    public String getKey() {
        return key;
    }
    public void setKey(String value) {
        key = value;
    }

    private String content;
    public String getContent() {
        return content;
    }
    public void setContent(String value) {
        content = value;
    }

    private String from;
    public String getFromRecipient() {
        return from;
    }
    public void setFromRecipient(String value) {
        from = value;
    }

    private String[] to;
    public String[] getToRecipients() {
        return to;
    }
    public void setToRecipients(String[] values) {
        to = values;
    }

    private String[] cc;
    public String[] getCarbonCopyRecipients() {
        return cc;
    }
    public void setCarbonCopyRecipients(String[] values) {
        to = values;
    }

    private String[] bcc;
    public String[] getBlindCarbonCopyRecipients() {
        return bcc;
    }
    public void setBlindCarbonCopyRecipients(String[] values) {
        to = values;
    }
}