package messengerd;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AttachmentRepository extends CrudRepository<Attachment, Long> {
    List<Attachment> findByKey(String value);
}