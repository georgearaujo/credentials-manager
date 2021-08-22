package com.edu.credentialsmanager.domain.exception;

import com.edu.credentialsmanager.domain.exception.handler.ExceptionResponse;

public class UsernameAlreadyExistsException extends ServiceException {

    @Override
    public ExceptionResponse getException() {
        return ExceptionResponse.USERNAME_ALREADY_EXISTS;
    }
}
