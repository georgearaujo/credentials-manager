package com.edu.credentialsmanager.domain.valueobjects;

import com.edu.credentialsmanager.domain.exception.InvalidPasswordException;

import java.util.regex.Pattern;

public class Password {
    private static final Pattern VALID_PASSWORD_REGEX =
            Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$*&@#])[0-9a-zA-Z$*&@#]{8,}$",
                    Pattern.CASE_INSENSITIVE);

    private String value;

    public Password(String value) {
        this.value = value != null ? value : "";
        var matcher = VALID_PASSWORD_REGEX.matcher(this.value);
        if(!matcher.find()) {
            throw new InvalidPasswordException();
        }
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Object is valid.";
    }

    @Override
    public boolean equals(Object o) {
        var password = (Password) o;
        return password != null && this.value.equals(password.getValue());
    }
}
