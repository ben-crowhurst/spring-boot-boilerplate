package messengerd;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class AttachmentTest {
    private Attachment attachment = new Attachment();

    @Test
    public void defaultInstanceValues() {
        assertThat(attachment.getKey(), not(isEmptyString()));
        assertThat(attachment.getContent(), is(new byte[0]));
        assertThat(attachment.getContentType(), isEmptyString());
    }
}