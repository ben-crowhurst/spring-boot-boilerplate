package messengerd;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages/{key}")
public class MessageController {
    @RequestMapping(method=RequestMethod.GET)
    public Message read(@PathVariable("key") String key) {
        Message message = new Message();
        return message;
    }

    @RequestMapping(method=RequestMethod.HEAD)
    public void head(@PathVariable("key") String key) {
        return;
    }

    @RequestMapping(method=RequestMethod.DELETE)
    public void delete(@PathVariable("key") String key) {
        return;
    }
}