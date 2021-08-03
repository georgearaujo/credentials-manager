package com.edu.credentialsmanager.domain.exception.handler;

import com.edu.credentialsmanager.domain.exception.InvalidEmailException;
import com.edu.credentialsmanager.domain.exception.InvalidPasswordException;
import com.edu.credentialsmanager.domain.exception.InvalidUsernameException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.edu.credentialsmanager.domain.exception.handler.ExceptionResponse.*;

@RestControllerAdvice
class GlobalHandlerExceptionResolver {

    @ExceptionHandler(InvalidUsernameException.class)
    public ResponseEntity<DefaultException> invalidUsername(InvalidUsernameException e) {
        return recoverException(INVALID_USERNAME);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<DefaultException> invalidPassword(InvalidPasswordException e) {
        return recoverException(INVALID_PASSWORD);
    }

    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<DefaultException> invalidEmail(InvalidEmailException e) {
        return recoverException(INVALID_EMAIL);
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