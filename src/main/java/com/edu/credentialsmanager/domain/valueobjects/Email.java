package com.edu.credentialsmanager.domain.valueobjects;

import com.edu.credentialsmanager.domain.exception.EmailFormatIsInvalidException;

import java.util.regex.Pattern;

public class Email {
    private static final Pattern VALID_EMAIL_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                    Pattern.CASE_INSENSITIVE);

    private final String value;

    public Email(String value) {
        this.value = value != null ? value : "";
        var matcher = VALID_EMAIL_REGEX.matcher(this.value);
        if(!matcher.find()) {
            throw new EmailFormatIsInvalidException();
        }
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    @Override
    public boolean equals(Object o) {
        var email = (Email) o;
        return email != null && this.getValue().equals(email.getValue());
    }
}
