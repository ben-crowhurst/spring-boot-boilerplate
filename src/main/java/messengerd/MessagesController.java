package messengerd;

import org.springframework.web.bind.annotation.*;

@RestController
public class MessagesController {
    @RequestMapping(value="/messages", method=RequestMethod.POST)
    public Message create() {
        Message message = new Message();
        return message;
    }

    @RequestMapping(value="/messages", method=RequestMethod.GET)
    public Message[] read() {
        Message[] messages = new Message[0];
        return messages;
    }

    @RequestMapping(value="/messages", method=RequestMethod.HEAD)
    public Message[] head(@PathVariable("key") String key) {
        Message[] messages = new Message[0];
        return messages;
    }
}