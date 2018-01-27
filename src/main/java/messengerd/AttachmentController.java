package messengerd;

import org.springframework.web.bind.annotation.*;

@RestController
public class AttachmentController {
    @RequestMapping(value="/attachments/{key}", method=RequestMethod.GET)
    public Attachment read() {
        Attachment attachment = new Attachment();
        return attachment;
    }

    @RequestMapping(value="/attachments/{key}", method=RequestMethod.HEAD)
    public Attachment head(@PathVariable("key") String key) {
        Attachment attachment = new Attachment();
        return attachment;
    }

    @RequestMapping(value="/attachments/{key}", method=RequestMethod.DELETE)
    public void delete(@PathVariable("key") String key) {
        return;
    }
}