package com.edu.credentialsmanager.domain.exception;

import com.edu.credentialsmanager.domain.exception.handler.ExceptionResponse;

public class PasswordFormatIsInvalidException extends ServiceException {

    @Override
    public ExceptionResponse getException() {
        return ExceptionResponse.PASSWORD_FORMAT_IS_INVALID;
    }
}
