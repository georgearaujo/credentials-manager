package com.edu.credentialsmanager.adapter.api;

import com.edu.credentialsmanager.adapter.dto.request.UserDTO;
import com.edu.credentialsmanager.domain.ports.UserRepository;
import com.edu.credentialsmanager.domain.services.CreateUser;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("user")
public class UserResource {

    private final UserRepository userRepository;

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    @ResponseStatus(OK)
    public void getUserByUuid(@RequestParam("UUID") UUID uuid) {

    }

    @PostMapping
    @ResponseStatus(CREATED)
    public UserDTO createUser(@RequestBody @Valid UserDTO userDto) {
        var createUser = new CreateUser(userRepository);
        var newUser = createUser.execute(userDto.toUser());
        return new UserDTO(newUser);
    }

    @PutMapping
    @ResponseStatus(OK)
    public void updateUser() {

    }

    @DeleteMapping
    @ResponseStatus(NO_CONTENT)
    public void deleteUser() {

    }
}