package com.edu.credentialsmanager.adapter.persistence;

import com.edu.credentialsmanager.domain.entities.User;
import com.edu.credentialsmanager.domain.ports.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRepositoryManager implements UserRepository {

    private final UserJpaRepository userRepository;

    public UserRepositoryManager(UserJpaRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findByEmail(String value) {
        return userRepository.findByEmail(value);
    }

    @Override
    public Optional<User> findByUsername(String value) {
        return userRepository.findByUsername(value);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
