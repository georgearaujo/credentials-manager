package com.edu.credentialsmanager.domain.exception;

import com.edu.credentialsmanager.domain.exception.handler.ExceptionResponse;

public class EmailFormatIsInvalidException extends ServiceException {

    @Override
    public ExceptionResponse getException() {
        return ExceptionResponse.EMAIL_FORMAT_IS_INVALID;
    }
}
