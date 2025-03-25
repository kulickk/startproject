package dev.kulick.startproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_GATEWAY)
public class CustomException extends RuntimeException {
    public CustomException(String msg) {
        super(msg);
    }
}
