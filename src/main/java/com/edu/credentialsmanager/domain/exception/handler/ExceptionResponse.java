package com.edu.credentialsmanager.domain.exception.handler;

import org.springframework.http.HttpStatus;

public enum ExceptionResponse {

    INVALID_LOGIN("LOGIN-001", "Login inválido.", HttpStatus.BAD_REQUEST),

    GENERIC_ERROR("ERROR-999", "Exception: %s", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String code;
    private final String description;
    private final HttpStatus status;

    ExceptionResponse(String code, String description, HttpStatus status) {
        this.code = code;
        this.description = description;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public HttpStatus getStatus() {
        return status;
    }
}