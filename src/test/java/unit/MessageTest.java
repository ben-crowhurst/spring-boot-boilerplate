package messengerd;

import org.junit.*;
import java.time.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class MessageTest {
    private Message message = new Message();

    @Test
    public void defaultInstanceValues() {
        long now = Instant.now().getEpochSecond();
        assertThat(message.getCreatedTimestamp(), anyOf(greaterThan(now), equalTo(now)));
        assertThat(message.getStatus(), equalToIgnoringCase("pending"));
        assertThat(message.getKey(), isEmptyString());
        assertThat(message.getContent(), isEmptyString());
        assertThat(message.getFromRecipient(), isEmptyString());
        assertThat(message.getToRecipients(), is(emptyArray()));
        assertThat(message.getCarbonCopyRecipients(), is(emptyArray()));
        assertThat(message.getBlindCarbonCopyRecipients(), is(emptyArray()));
    }
}