package messenger.service;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.annotation.*;
import org.springframework.test.context.junit4.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

import messenger.data.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AttachmentsControllerTest {
    @Autowired
    private AttachmentRepository repository;

    @Before
    public void reset() {
        repository.deleteAll();
    }

    @Autowired
    private AttachmentsController controller;

    @Test
    public void createResource() {
        String contentType = "";
        byte[] content = new byte[0];
        Attachment attachment = controller.create(content, contentType);

        assertThat(attachment.getKey(), not(isEmptyString()));
        assertThat(attachment.getContent(), is(new byte[0]));
        assertThat(attachment.getContentType(), isEmptyString());
    }

    @Test
    public void createResourceWithCustomProperties() {
        String contentType = "text/html";
        byte[] content = "If they squeeze olives to get olive oil, what do they squeeze to get baby oil?".getBytes();
        Attachment attachment = controller.create(content, contentType);

        assertThat(attachment.getContentType(), is(contentType));
        assertThat(attachment.getContent(), is(content));
    }
}