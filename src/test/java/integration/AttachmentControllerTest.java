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
public class AttachmentControllerTest {
    @Autowired
    private AttachmentRepository repository;

    @Before
    public void reset() {
        repository.deleteAll();
    }

    @Autowired
    private AttachmentController resourceController;

    @Autowired
    private AttachmentsController collectionController;

    @Test
    public void deleteResource() {
        String contentType = "text/html";
        byte[] content = "Why did the Flinstones have Christmas?".getBytes();
        Attachment attachment = collectionController.create(content, contentType);
        assertThat(repository.count(), is(1L));

        resourceController.delete(attachment.getKey());
        assertThat(repository.count(), is(0L));
    }

    @Test
    public void deleteUnknownResource() {
        String contentType = "text/html";
        byte[] content = "Why did the Flinstones have Christmas?".getBytes();
        Attachment attachment = collectionController.create(content, contentType);
        assertThat(repository.count(), is(1L));

        resourceController.delete("non-existent-key");
        assertThat(repository.count(), is(1L));
    }
}