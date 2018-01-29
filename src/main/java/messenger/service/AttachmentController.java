package messenger.service;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

import messenger.data.*;

@RestController
@RequestMapping("/attachments/{key}")
public class AttachmentController {
    @Autowired
    private AttachmentRepository repository;

    @RequestMapping(method=RequestMethod.DELETE)
    public void delete(@PathVariable("key") String value) {
        List<Attachment> attachments = repository.findByKey(value);
        repository.delete(attachments);
    }
}