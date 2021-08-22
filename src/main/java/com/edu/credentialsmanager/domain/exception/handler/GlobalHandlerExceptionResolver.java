package com.edu.credentialsmanager.domain.exception.handler;

import com.edu.credentialsmanager.domain.exception.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.edu.credentialsmanager.domain.exception.handler.ExceptionResponse.GENERIC_ERROR;

@RestControllerAdvice
class GlobalHandlerExceptionResolver {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<DefaultException> serviceException(ServiceException exception) {
        return recoverException(exception.getException());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DefaultException> exception(Exception e) {
        return recoverException(GENERIC_ERROR, e.getMessage());
    }

    private ResponseEntity<DefaultException> recoverException(ExceptionResponse exception, String... args) {
        String description = String.format(exception.getDescription(), args);

        //TODO Remover
        System.out.println(description);

        var defaultException = new DefaultException(exception.getCode(), description);
        return new ResponseEntity<>(defaultException, exception.getStatus());
    }
}