package com.example.SimpleInvest.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.SimpleInvest.dtos.CreateAccontDto;
import com.example.SimpleInvest.dtos.UpdateUserDto;
import com.example.SimpleInvest.dtos.UserDto;
import com.example.SimpleInvest.entity.Account;
import com.example.SimpleInvest.entity.BillingAddress;
import com.example.SimpleInvest.entity.User;
import com.example.SimpleInvest.repository.AccountRepository;
import com.example.SimpleInvest.repository.BillingAddressRepository;
import com.example.SimpleInvest.repository.UserRepository;

@Service
public class UserService {

    private UserRepository repository;

    private BillingAddressRepository bAddressRepository;

    private AccountRepository accountRepository;

    public UserService(UserRepository repository, BillingAddressRepository bAddressRepository,
            AccountRepository accountRepository) {
        this.repository = repository;
        this.bAddressRepository = bAddressRepository;
        this.accountRepository = accountRepository;
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

    public void createAccount(UUID userId, CreateAccontDto createAccontDto) {

        var user = repository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        var account = new Account(
                UUID.randomUUID(),
                createAccontDto.description(),
                user,
                null,
                new ArrayList<>());

        var accountCreated = accountRepository.save(account);

        var billingAddress = new BillingAddress(
                accountCreated.getAccountId(),
                createAccontDto.street(),
                createAccontDto.number(),
                account);

        bAddressRepository.save(billingAddress);

    }
}