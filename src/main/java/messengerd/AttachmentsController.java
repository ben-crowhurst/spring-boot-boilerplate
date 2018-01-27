package messengerd;

import org.springframework.web.bind.annotation.*;

@RestController
public class AttachmentsController {
    @RequestMapping(value="/attachments", method=RequestMethod.POST)
    public Attachment create() {
        Attachment attachment = new Attachment();
        return attachment;
    }

    @RequestMapping(value="/attachments", method=RequestMethod.GET)
    public Attachment[] read() {
        Attachment[] attachments = new Attachment[0];
        return attachments;
    }

    @RequestMapping(value="/attachments", method=RequestMethod.HEAD)
    public Attachment[] head(@PathVariable("key") String key) {
        Attachment[] attachments = new Attachment[0];
        return attachments;
    }
}