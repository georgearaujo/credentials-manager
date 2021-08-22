package com.edu.credentialsmanager.domain.services;

import com.edu.credentialsmanager.domain.entities.User;
import com.edu.credentialsmanager.domain.exception.EmailAlreadyExistsException;
import com.edu.credentialsmanager.domain.exception.UsernameAlreadyExistsException;
import com.edu.credentialsmanager.domain.ports.UserRepository;

public class CreateUser {

    private final UserRepository userRepository;

    public CreateUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(User user) {
        var userEmail= userRepository.findByEmail(user.getEmail().getValue());
        if(userEmail.isPresent()) {
            throw new EmailAlreadyExistsException();
        }

        var userUsername= userRepository.findByUsername(user.getUsername().getValue());
        if(userUsername.isPresent()) {
            throw new UsernameAlreadyExistsException();
        }

        return userRepository.save(user);
    }
}