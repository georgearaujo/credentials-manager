package com.edu.credentialsmanager.domain.entities;

import com.edu.credentialsmanager.domain.valueobjects.Email;
import com.edu.credentialsmanager.domain.valueobjects.Password;
import com.edu.credentialsmanager.domain.valueobjects.Username;

import javax.persistence.GeneratedValue;
import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {

    private UUID uuid;

    private final Username username;

    private final Password password;

    private final Email email;

    public User(Username username, Password password, Email email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(UUID uuid, Username username, Password password, Email email) {
        this(username, password, email);
        this.uuid = uuid;
    }

    public User(UUID uuid, String username, String password, String email) {
        this(uuid, new Username(username), new Password(password), new Email(email));
    }

    public User(String username, String password, String email) {
        this(new Username(username), new Password(password), new Email(email));
    }

    public UUID getUuid() {
        return uuid;
    }

    public Username getUsername() {
        return username;
    }

    public Password getPassword() {
        return password;
    }

    public Email getEmail() {
        return email;
    }
}
