package com.example.SimpleInvest.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SimpleInvest.dtos.UpdateUserDto;
import com.example.SimpleInvest.dtos.UserDto;
import com.example.SimpleInvest.entity.User;
import com.example.SimpleInvest.service.UserService;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto userdto) {
        service.createUser(userdto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(UUID id) {
        if (service.findUserById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var user = service.findUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        var users = service.listUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("{userId}")
    public void updateUserById(@PathVariable("userId") String userId,
            @RequestBody UpdateUserDto userdto) {
        service.updateUser(userId, userdto);
        ResponseEntity.noContent().build();
    }
}