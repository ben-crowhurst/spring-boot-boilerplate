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
public class MessageControllerTest {
    @Autowired
    private MessageRepository repository;

    @Before
    public void reset() {
        repository.deleteAll();
    }

    @Autowired
    private MessageController resourceController;

    @Autowired
    private MessagesController collectionController;

    @Test
    public void readResource() {
        Message message = new Message();

        String key = "my-unique-key";
        message.setKey(key);

        collectionController.create(message);
        message = resourceController.read(key);
        assertThat(message.getKey(), equalToIgnoringCase(key));
    }

    @Test
    public void readUnknownResource() {
        try {
            Message message = resourceController.read("non-existent-key");
            assertThat(false, is(false));
        } catch (NotFoundException nfe) {
            assertThat(true, is(true));
        }
    }

    @Test
    public void deleteResource() {
        Message message = collectionController.create(new Message());
        assertThat(repository.count(), is(1L));

        resourceController.delete(message.getKey());
        assertThat(repository.count(), is(0L));
    }

    @Test
    public void deleteUnknownResource() {
        collectionController.create(new Message());
        assertThat(repository.count(), is(1L));

        resourceController.delete("non-existent-key");
        assertThat(repository.count(), is(1L));
    }
}