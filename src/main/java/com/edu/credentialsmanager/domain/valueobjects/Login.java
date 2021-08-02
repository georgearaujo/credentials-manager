package com.edu.credentialsmanager.domain.valueobjects;

import com.edu.credentialsmanager.domain.exception.InvalidLoginException;

import java.util.regex.Pattern;

public class Login {
    private static final Pattern VALID_LOGIN_REGEX =
            Pattern.compile("/^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$*&@#])[0-9a-zA-Z$*&@#]{8,}$/",
                    Pattern.CASE_INSENSITIVE);

    private String value;

    public Login(String value) {
        this.value = value != null ? value : "";
        var matcher = VALID_LOGIN_REGEX.matcher(value);
        if(!matcher.find()) {
            throw new InvalidLoginException();
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
        var login = (Login) o;
        return login != null && this.value.equals(login.getValue());
    }
}