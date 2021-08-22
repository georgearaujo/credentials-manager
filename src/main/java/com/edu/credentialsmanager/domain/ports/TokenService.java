package com.edu.credentialsmanager.domain.ports;

public interface TokenService {

    void validateToken();
    void refreshToken();
}
