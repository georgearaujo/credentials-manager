package com.edu.credentialsmanager.adapter.dto.request;

import com.edu.credentialsmanager.domain.entities.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class UserDTO {
    private UUID uuid;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Email
    @NotBlank
    private String email;

    UserDTO() {

    }

    public UserDTO(User user) {
        this.uuid = user.getUuid();
        this.username = user.getUsername().getValue();
        this.email = user.getEmail().getValue();
    }

    public User toUser() {
        return new User(username, password, email);
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
