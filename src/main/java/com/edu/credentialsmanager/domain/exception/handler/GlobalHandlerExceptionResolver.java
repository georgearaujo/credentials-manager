package com.edu.credentialsmanager.domain.exception.handler;

import com.edu.credentialsmanager.domain.exception.InvalidLoginException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.edu.credentialsmanager.domain.exception.handler.ExceptionResponse.GENERIC_ERROR;
import static com.edu.credentialsmanager.domain.exception.handler.ExceptionResponse.INVALID_LOGIN;

@RestControllerAdvice
class GlobalHandlerExceptionResolver {

    @ExceptionHandler(InvalidLoginException.class)
    public ResponseEntity<DefaultException> invalidLogin(InvalidLoginException e) {
        return recoverException(INVALID_LOGIN);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DefaultException> exception(Exception e) {
        return recoverException(GENERIC_ERROR, e.getMessage());
    }

    private ResponseEntity<DefaultException> recoverException(ExceptionResponse exception, String... args) {
        String description = String.format(exception.getDescription(), args);
        var defaultException = new DefaultException(exception.getCode(), description);
        return new ResponseEntity<>(defaultException, exception.getStatus());
    }
}