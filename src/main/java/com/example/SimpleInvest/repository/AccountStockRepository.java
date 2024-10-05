package com.example.SimpleInvest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SimpleInvest.entity.AccountStock;
import com.example.SimpleInvest.entity.AccountStockId;

public interface AccountStockRepository extends JpaRepository<AccountStock, AccountStockId> {
}