package messengerd;

import javax.persistence.*;

public class Attachment {
    public Attachment() {
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

    private String key = "";
    public String getKey() {
        return key;
    }
    public void setKey(String value) {
        key = value;
    }

    private byte[] content = { };
    public byte[] getContent() {
        return content;
    }
    public void setContent(byte[] value) {
        content = value;
    }

    private String contentType = "";
    public String getContentType() {
        return contentType;
    }
    public void setContentType(String value) {
        contentType = value;
    }
}