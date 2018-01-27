package messengerd;

import javax.persistence.*;

@Entity
public class Message {
    public Message() {
        return;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id = 0;
    public long getId() {
        return id;
    }
    public void setId(Long value) {
        id = value;
    }

    private long createdTimestamp = 0;
    public long getCreatedTimestamp() {
        return createdTimestamp;
    }
    public void setCreatedTimestamp(long value) {
        createdTimestamp = value;
    }

    private String status = "";
    public String getStatus() {
        return status;
    }
    public void setStatus(String value) {
        status = value;
    }

    private String key = "";
    public String getKey() {
        return key;
    }
    public void setKey(String value) {
        key = value;
    }

    private String content = "";
    public String getContent() {
        return content;
    }
    public void setContent(String value) {
        content = value;
    }

    private String from = "";
    public String getFromRecipient() {
        return from;
    }
    public void setFromRecipient(String value) {
        from = value;
    }

    private String[] to = { };
    public String[] getToRecipients() {
        return to;
    }
    public void setToRecipients(String[] values) {
        to = values;
    }

    private String[] cc = { };
    public String[] getCarbonCopyRecipients() {
        return cc;
    }
    public void setCarbonCopyRecipients(String[] values) {
        cc = values;
    }

    private String[] bcc = { };
    public String[] getBlindCarbonCopyRecipients() {
        return bcc;
    }
    public void setBlindCarbonCopyRecipients(String[] values) {
        bcc = values;
    }
}