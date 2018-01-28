package messenger.service;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@RestController
@RequestMapping("/attachments")
public class AttachmentsController {
    @Autowired
    private AttachmentRepository repository;

    @RequestMapping(method=RequestMethod.POST)
    public Attachment create(@RequestBody byte[] content, @RequestHeader(value="Content-Type") String contentType) {
        Attachment attachment = new Attachment();
        attachment.setContent(content);
        attachment.setContentType(contentType);
        attachment.setKey(UUID.randomUUID().toString());

        return repository.save(attachment);
    }
}