package com.example.SimpleInvest.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SimpleInvest.entity.BillingAddress;

public interface BillingAddressRepository extends JpaRepository<BillingAddress, UUID> {
}