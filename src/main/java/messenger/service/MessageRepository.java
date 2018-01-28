package messenger.service;

import java.util.*;

import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findByKey(String value);
}