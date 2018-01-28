package messengerd;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException extends RuntimeException {
    public NotFoundException() {
        return;
    }

    public NotFoundException(String message) {
        super(message);
    }
}