package messengerd;

import java.time.*;
import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessagesController {
    @Autowired
    private MessageRepository repository;

    @RequestMapping(method=RequestMethod.POST)
    public Message create(@RequestBody Message message) {
        message.setStatus("pending");
        message.setCreatedTimestamp(Instant.now().getEpochSecond());

        String key = message.getKey();
        if (key.isEmpty()) {
            message.setKey(UUID.randomUUID().toString());
        }

        return repository.save(message);
    }

    @RequestMapping(method=RequestMethod.GET)
    public Iterable<Message> read() {
        return repository.findAll();
    }
}