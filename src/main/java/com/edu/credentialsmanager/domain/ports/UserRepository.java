package com.edu.credentialsmanager.domain.ports;

import com.edu.credentialsmanager.domain.entities.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    User save(User user);
}
