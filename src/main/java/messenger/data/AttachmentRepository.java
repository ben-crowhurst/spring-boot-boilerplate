package messenger.data;

import java.util.*;
import org.springframework.data.repository.*;

public interface AttachmentRepository extends CrudRepository<Attachment, Long> {
    List<Attachment> findByKey(String value);
}