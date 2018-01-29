package messenger.data;

import java.util.*;
import org.springframework.data.repository.*;

public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findByKey(String value);

    List<Message> findByStatus(String value);
}