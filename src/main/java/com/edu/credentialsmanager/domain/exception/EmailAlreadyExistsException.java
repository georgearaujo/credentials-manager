package com.edu.credentialsmanager.domain.exception;

import com.edu.credentialsmanager.domain.exception.handler.ExceptionResponse;

public class EmailAlreadyExistsException extends ServiceException {

    @Override
    public ExceptionResponse getException() {
        return ExceptionResponse.EMAIL_ALREADY_EXISTS;
    }
}
