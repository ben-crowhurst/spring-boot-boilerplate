package messenger.service;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

import messenger.data.*;

@RestController
@RequestMapping("/messages/{key}")
public class MessageController {
    @Autowired
    private MessageRepository repository;

    @RequestMapping(method=RequestMethod.GET)
    public Message read(@PathVariable("key") String value) {
        List<Message> messages = repository.findByKey(value);
        if (messages.isEmpty()) {
            throw new NotFoundException();
        }

        return messages.get(0);
    }

    @RequestMapping(method=RequestMethod.DELETE)
    public void delete(@PathVariable("key") String value) {
        List<Message> messages = repository.findByKey(value);
        repository.delete(messages);
    }
}