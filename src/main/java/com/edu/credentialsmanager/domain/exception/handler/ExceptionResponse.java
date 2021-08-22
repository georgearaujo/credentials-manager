package com.edu.credentialsmanager.domain.exception.handler;

import org.springframework.http.HttpStatus;

public enum ExceptionResponse {

    USERNAME_FORMAT_IS_INVALID("USER-001", "Username format is invalid.", HttpStatus.BAD_REQUEST),
    USERNAME_ALREADY_EXISTS("USER-002", "Username already exists.", HttpStatus.BAD_REQUEST),

    PASSWORD_FORMAT_IS_INVALID("PASS-001", "Password format is invalid.", HttpStatus.BAD_REQUEST),
    
    EMAIL_FORMAT_IS_INVALID("EMAIL-001", "Email format is invalid.", HttpStatus.BAD_REQUEST),
    EMAIL_ALREADY_EXISTS("EMAIL-002", "Email already exists.", HttpStatus.BAD_REQUEST),
    
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