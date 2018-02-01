# spring-boot-tut
Sprint Boot Upskilling

# build
mvn spring-boot:run
mvn test

# send
curl -XPOST --data '{"fromSender":"ben.crowhurst@outlook.com", "toRecipients":["ben.crowhurst@corvusoft.co.uk"], "content":"hello, world!", "subject": "test email"}' http://localhost:8080/messages -v -H"Content-Type: application/json"

