package com.example.SimpleInvest.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SimpleInvest.entity.Account;

public interface AccountRepository extends JpaRepository<Account, UUID> {
}