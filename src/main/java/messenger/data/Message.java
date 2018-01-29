package messenger.data;

import java.util.*;
import javax.persistence.*;

@Entity
public class Message {
    public Message() {
        return;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id = 0L;
    public Long getId() {
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

    private long deliveryAttempts = 0;
    public long getDeliveryAttempts() {
        return deliveryAttempts;
    }
    public void setDeliveryAttempts(long value) {
        deliveryAttempts = value;
    }

    private String[] errorLog = { };
    public List<String> getErrorLog() {
        return Arrays.asList(errorLog);
    }
    public void setErrorLog(List<String> values) {
        errorLog = values.stream().toArray(String[]::new);
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

    private String fromRecipient = "";
    public String getFromRecipient() {
        return fromRecipient;
    }
    public void setFromRecipient(String value) {
        fromRecipient = value;
    }

    private String[] toRecipients = { };
    public String[] getToRecipients() {
        return toRecipients;
    }
    public void setToRecipients(String[] values) {
        toRecipients = values;
    }

    private String[] ccRecipients = { };
    public String[] getCarbonCopyRecipients() {
        return ccRecipients;
    }
    public void setCarbonCopyRecipients(String[] values) {
        ccRecipients = values;
    }

    private String[] bccRecipients = { };
    public String[] getBlindCarbonCopyRecipients() {
        return bccRecipients;
    }
    public void setBlindCarbonCopyRecipients(String[] values) {
        bccRecipients = values;
    }
}