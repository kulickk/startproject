package dev.kulick.startproject.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

import dev.kulick.startproject.models.ErrorResponse;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now().toString(),
                HttpStatus.BAD_GATEWAY.value(),
                "unavailable id",
                ex.getMessage(),
                request.getDescription(false).replace("uri=", ""));

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}