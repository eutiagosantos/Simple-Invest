package com.example.SimpleInvest.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.SimpleInvest.dtos.UpdateUserDto;
import com.example.SimpleInvest.dtos.UserDto;
import com.example.SimpleInvest.entity.User;
import com.example.SimpleInvest.repository.UserRepository;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(UserDto userdto) {
        var entity = new User(UUID.randomUUID(),
                userdto.name(),
                userdto.email(),
                userdto.password(),
                Instant.now(),
                null);

        return repository.save(entity);
    }

    public Optional<User> findUserById(UUID userid) {
        return repository.findById(userid);
    }

    public List<User> listUsers() {
        return repository.findAll();
    }

    public void updateUser(String userId, UpdateUserDto userdto) {
        var id = UUID.fromString(userId);

        var userExists = repository.findById(id);

        if (userExists.isPresent()) {
            var user = userExists.get();

            if (userdto.name() != null) {
                user.setName(userdto.name());
            }

            if (userdto.password() != null) {
                user.setPassword(userdto.password());
            }
            repository.save(user);
        }
    }

    public void deleteUser(UUID userid) {
        repository.deleteById(userid);
    }
}