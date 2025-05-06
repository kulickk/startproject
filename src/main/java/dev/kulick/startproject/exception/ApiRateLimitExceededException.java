package dev.kulick.startproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
public class ApiRateLimitExceededException extends RuntimeException {
    public ApiRateLimitExceededException(String message) {
        super(message);
    }
}