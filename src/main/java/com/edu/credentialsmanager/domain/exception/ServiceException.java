package com.edu.credentialsmanager.domain.exception;

import com.edu.credentialsmanager.domain.exception.handler.ExceptionResponse;

public abstract class ServiceException extends RuntimeException {

    public abstract ExceptionResponse getException();
}
