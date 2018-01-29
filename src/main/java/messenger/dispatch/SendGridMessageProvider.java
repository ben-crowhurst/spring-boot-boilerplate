package messenger.dispatch;

import java.io.*;
import java.net.*;
import javax.json.*;
import java.nio.charset.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

import messenger.data.*;

@Service
public class SendGridMessageProvider implements MessageProvider {
    private final String apiKey;
    private final URL endpointURI;
    private final int readTimeout;
    private final int connectionTimeout;

    @Autowired
    public SendGridMessageProvider(
        @Value("${sendgrid.readTimeout}") int readTimeout,
        @Value("${sendgrid.connectionTimeout}") int connectionTimeout,
        @Value("${sendgrid.apiKey}") String apiKey,
        @Value("${sendgrid.uri:https://api.sendgrid.com/v3/mail/send}") String uri
    ) throws MalformedURLException {
        this.apiKey = "Bearer " + apiKey;
        this.endpointURI = new URL(uri);
        this.readTimeout = readTimeout;
        this.connectionTimeout = connectionTimeout;
    }

    @Override
    public void send(Message message) {
        try {
            System.out.println(new String(buildPayload(message), StandardCharsets.UTF_8));

            byte[] body = buildPayload(message);

            HttpURLConnection connection = (HttpURLConnection) endpointURI.openConnection();
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.setReadTimeout(readTimeout);
            connection.setConnectTimeout(connectionTimeout);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", apiKey);
            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            connection.setRequestProperty( "Content-Length", Integer.toString( body.length ));
            try(DataOutputStream stream = new DataOutputStream(connection.getOutputStream())) {
                stream.write( body );
            }

            int statusCode = connection.getResponseCode();
            if (statusCode < 200 || statusCode > 299) {
                throw new MessageProviderException("sendgrid", connection.getResponseMessage());
            }
        } catch (IOException ex) {
            throw new MessageProviderException("sendgrid", ex.getMessage());
        }
    }

    private byte[] buildPayload(Message message) {
        JsonBuilderFactory factory = Json.createBuilderFactory(null);
        JsonArrayBuilder personalizations = factory.createArrayBuilder();

        JsonArrayBuilder recipients = factory.createArrayBuilder();
        for (String recipient : message.getToRecipients()) {
            recipients.add(factory.createObjectBuilder().add("email", recipient));
        }
        personalizations.add(factory.createObjectBuilder().add("to", recipients));

        String[] data = message.getCarbonCopyRecipients();
        if (data.length != 0) {
            recipients = factory.createArrayBuilder();
            for (String recipient : message.getCarbonCopyRecipients()) {
                recipients.add(factory.createObjectBuilder().add("email", recipient));
            }
            personalizations.add(factory.createObjectBuilder().add("cc", recipients));
        }

        data = message.getCarbonCopyRecipients();
        if (data.length != 0) {
            recipients = factory.createArrayBuilder();
            for (String recipient : message.getBlindCarbonCopyRecipients()) {
                recipients.add(factory.createObjectBuilder().add("email", recipient));
            }
            personalizations.add(factory.createObjectBuilder().add("bcc", recipients));
        }

        JsonArrayBuilder content = factory.createArrayBuilder();
        content.add(factory.createObjectBuilder().add("type", "text/plain").add("value", message.getContent()));

        JsonObjectBuilder payload = factory.createObjectBuilder();
        payload.add("content", content);
        payload.add("subject", message.getSubject());
        payload.add("personalizations", personalizations);
        payload.add("from", factory.createObjectBuilder().add("email", message.getFromSender()));

        return payload.build().toString().getBytes(StandardCharsets.UTF_8);
    }
}