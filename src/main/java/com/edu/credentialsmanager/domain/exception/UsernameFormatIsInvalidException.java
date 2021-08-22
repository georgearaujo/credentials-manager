package com.edu.credentialsmanager.domain.exception;

import com.edu.credentialsmanager.domain.exception.handler.ExceptionResponse;

public class UsernameFormatIsInvalidException extends ServiceException {

    @Override
    public ExceptionResponse getException() {
        return ExceptionResponse.USERNAME_FORMAT_IS_INVALID;
    }
}