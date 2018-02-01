# spring-boot-tut
Email messenger with fail-over.  See issues for outstanding work items.

# Dependendices
 - Maven 3
 - Java 1.9

# Build
mvn spring-boot:run
mvn test

# Send
curl -XPOST --data '{"fromSender":"ben.crowhurst@outlook.com", "toRecipients":["ben.crowhurst@corvusoft.co.uk"], "content":"hello, world!", "subject": "test email"}' http://localhost:8080/messages -v -H"Content-Type: application/json"
