package messengerd;

import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {
    @RequestMapping(value="/messages/{key}", method=RequestMethod.GET)
    public Message read() {
        Message message = new Message();
        return message;
    }

    @RequestMapping(value="/messages/{key}", method=RequestMethod.HEAD)
    public Message head(@PathVariable("key") String key) {
        Message message = new Message();
        return message;
    }

    @RequestMapping(value="/messages/{key}", method=RequestMethod.DELETE)
    public void delete(@PathVariable("key") String key) {
        return;
    }
}