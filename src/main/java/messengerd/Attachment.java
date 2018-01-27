package messengerd;

import java.util.*;

public class Attachment {
    public Attachment() {
        key = UUID.randomUUID().toString();
        content = new byte[0];
        contentType = "";
    }

    private String key;
    public String getKey() {
        return key;
    }
    public void setKey(String value) {
        key = value;
    }

    private byte[] content;
    public byte[] getContent() {
        return content;
    }
    public void setContent(byte[] value) {
        content = value;
    }

    private String contentType;
    public String getContentType() {
        return contentType;
    }
    public void setContentType(String value) {
        contentType = value;
    }
}