package com.edu.credentialsmanager.domain.exception.handler;

public class DefaultException {

    private String code;
    private String description;

    public DefaultException(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}