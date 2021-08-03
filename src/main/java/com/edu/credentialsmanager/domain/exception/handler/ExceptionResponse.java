package com.edu.credentialsmanager.domain.exception.handler;

import org.springframework.http.HttpStatus;

public enum ExceptionResponse {

    INVALID_USERNAME("USER-001", "Invalid username.", HttpStatus.BAD_REQUEST),
    INVALID_PASSWORD("USER-002", "Invalid password.", HttpStatus.BAD_REQUEST),
    INVALID_EMAIL("USER-003", "Invalid email.", HttpStatus.BAD_REQUEST),

    GENERIC_ERROR("ERROR-999", "%s", HttpStatus.INTERNAL_SERVER_ERROR);

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