package com.edu.credentialsmanager.domain.valueobjects;

import com.edu.credentialsmanager.domain.exception.InvalidUsernameException;

import java.util.regex.Pattern;

public class Username {
    private static final Pattern VALID_USERNAME_REGEX =
            Pattern.compile("^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$",
                    Pattern.CASE_INSENSITIVE);

    private String value;

    public Username(String value) {
        this.value = value != null ? value : "";
        var matcher = VALID_USERNAME_REGEX.matcher(value);
        if(!matcher.find()) {
            throw new InvalidUsernameException();
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        var login = (Username) o;
        return login != null && this.value.equals(login.getValue());
    }
}