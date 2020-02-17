# Messenger Java
Email messenger with fail-over.  See issues for outstanding work items.

# Dependendices
 - Maven 3
 - Java 1.9

# Build
mvn spring-boot:run

mvn test

# Send
curl -XPOST --data '{"fromSender":"12345@outlook.com", "toRecipients":["6789@outlook.com"], "content":"hello, world!", "subject": "test email"}' http://localhost:8080/messages -v -H"Content-Type: application/json"
