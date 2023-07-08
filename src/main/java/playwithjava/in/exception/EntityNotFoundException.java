package playwithjava.in.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class EntityNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private int code;

    public EntityNotFoundException(String message, int code) {
        super(message);
        this.code = code;
    }
}
