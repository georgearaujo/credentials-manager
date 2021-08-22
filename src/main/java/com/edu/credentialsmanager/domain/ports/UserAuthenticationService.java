package com.edu.credentialsmanager.domain.ports;

public interface UserAuthenticationService {

    void login();
    void logout();
    void forgotPassword();
}
