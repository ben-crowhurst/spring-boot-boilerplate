package messenger.service;

import java.util.*;

import org.springframework.data.repository.CrudRepository;

public interface AttachmentRepository extends CrudRepository<Attachment, Long> {
    List<Attachment> findByKey(String value);
}