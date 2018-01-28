package messenger.service;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.time.*;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.annotation.*;
import org.springframework.test.context.junit4.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MessagesControllerTest {
    @Autowired
    private MessageRepository repository;

    @Before
    public void reset() {
        repository.deleteAll();
    }

    @Autowired
    private MessagesController controller;

    @Test
    public void readAll() {
        Iterable<Message> messages = controller.read();
        long count = messages.spliterator().getExactSizeIfKnown();
        assertThat(count, is(0L));

        controller.create(new Message());
        controller.create(new Message());
        controller.create(new Message());

        messages = controller.read();
        count = messages.spliterator().getExactSizeIfKnown();
        assertThat(count, is(3L));
    }

    @Test
    public void createResource() {
        Message message = controller.create(new Message());

        long now = Instant.now().getEpochSecond();
        assertThat(message.getCreatedTimestamp(), anyOf(greaterThan(now), equalTo(now)));
        assertThat(message.getStatus(), equalToIgnoringCase("pending"));
        assertThat(message.getKey(), not(isEmptyString()));
        assertThat(message.getContent(), isEmptyString());
        assertThat(message.getFromRecipient(), isEmptyString());
        assertThat(message.getToRecipients(), is(emptyArray()));
        assertThat(message.getCarbonCopyRecipients(), is(emptyArray()));
        assertThat(message.getBlindCarbonCopyRecipients(), is(emptyArray()));
    }

    @Test
    public void createResourceWithPredefinedKey() {
        Message message = new Message();
        message.setKey("my-unique-key");
        message = controller.create(message);

        assertThat(message.getKey(), is("my-unique-key"));
    }

    @Test
    public void createResourceWithPredefinedStatus() {
        Message message = new Message();
        message.setStatus("delivered");
        message = controller.create(message);

        assertThat(message.getStatus(), equalToIgnoringCase("pending"));
    }

    @Test
    public void createResourceWithPredefinedCreatedTimestamp() {
        Message message = new Message();
        message.setCreatedTimestamp(793502543);
        message = controller.create(message);

        long now = Instant.now().getEpochSecond();
        assertThat(message.getCreatedTimestamp(), anyOf(greaterThan(now), equalTo(now)));
    }

    @Test
    public void createResourceWithCustomProperties() {
        Message message = new Message();

        String content = "Why do noses run, while feet smell?";
        message.setContent(content);

        String fromRecipient = "ben.crowhurst@comp.org";
        message.setFromRecipient(fromRecipient);

        String[] toRecipients = { "tom.crowhurst@comp.org", "ben.crowhurst@comp.org" };
        message.setToRecipients(toRecipients);

        String[] ccRecipients = { "james.crowhurst@comp.org" };
        message.setCarbonCopyRecipients(ccRecipients);

        String[] bccRecipients = { "amanda.crowhurst@comp.org", "graham.crowhurst@comp.org" };
        message.setBlindCarbonCopyRecipients(bccRecipients);

        message = controller.create(message);

        long now = Instant.now().getEpochSecond();
        assertThat(message.getContent(), is(content));
        assertThat(message.getFromRecipient(), is(fromRecipient));
        assertThat(message.getToRecipients(), arrayContainingInAnyOrder(toRecipients));
        assertThat(message.getCarbonCopyRecipients(), arrayContainingInAnyOrder(ccRecipients));
        assertThat(message.getBlindCarbonCopyRecipients(), arrayContainingInAnyOrder(bccRecipients));
    }
}