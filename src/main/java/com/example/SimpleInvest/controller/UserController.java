package com.example.SimpleInvest.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SimpleInvest.dtos.CreateAccontDto;
import com.example.SimpleInvest.dtos.UpdateUserDto;
import com.example.SimpleInvest.dtos.UserDto;
import com.example.SimpleInvest.entity.User;
import com.example.SimpleInvest.service.UserService;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private UserService userservice;

    public UserController(UserService service) {
        this.userservice = service;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto userdto) {
        userservice.createUser(userdto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(UUID id) {
        if (userservice.findUserById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var user = userservice.findUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        var users = userservice.listUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{userId}")
    public void updateUserById(@PathVariable("userId") String userId,
            @RequestBody UpdateUserDto userdto) {
        userservice.updateUser(userId, userdto);
        ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("userId") UUID userId) {
        userservice.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{userId}/accounts")
    public ResponseEntity<Void> createAccount(@PathVariable("userId") UUID userId,
            @RequestBody CreateAccontDto createAccontDto) {
        userservice.createAccount(userId, createAccontDto);
        return ResponseEntity.ok().build();
    }

}