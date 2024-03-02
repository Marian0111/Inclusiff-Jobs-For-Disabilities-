package org.sd.controllers;

import lombok.RequiredArgsConstructor;
import org.sd.api.UserApi;
import org.sd.dtos.*;
import org.sd.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000"})
public class UserController implements UserApi {
    private final UserService userService;

    @Override
    public ResponseEntity<UserDto> registerUser(UserRegistrationRequest userRegistrationRequest) {
        return ResponseEntity.ok(userService.createUser(userRegistrationRequest));
    }

    @Override
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Override
    public ResponseEntity<UserDto> getUser(UUID userExternalId) {
        return ResponseEntity.ok(userService.getUser(userExternalId));
    }

    @Override
    public ResponseEntity<UserDto> updateUser(UpdateUserRequest updateUserRequest) {
        return ResponseEntity.ok(userService.updateUser(updateUserRequest));
    }

    @Override
    public ResponseEntity<ResponseMessage> deleteUser(String cnp) {
        return ResponseEntity.ok(userService.deleteUser(cnp));
    }

    @Override
    public ResponseEntity<UserDto> login(LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.login(loginRequest));
    }
}
