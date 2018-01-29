package messenger.data;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class MessageTest {
    private Message message = new Message();

    @Test
    public void defaultInstanceValues() {
        assertThat(message.getCreatedTimestamp(), is(0L));
        assertThat(message.getStatus(), isEmptyString());
        assertThat(message.getDeliveryAttempts(), is(0L));
        assertThat(message.getErrorLog(), is(empty()));
        assertThat(message.getKey(), isEmptyString());
        assertThat(message.getContent(), isEmptyString());
        assertThat(message.getFromRecipient(), isEmptyString());
        assertThat(message.getToRecipients(), is(emptyArray()));
        assertThat(message.getCarbonCopyRecipients(), is(emptyArray()));
        assertThat(message.getBlindCarbonCopyRecipients(), is(emptyArray()));
    }
}