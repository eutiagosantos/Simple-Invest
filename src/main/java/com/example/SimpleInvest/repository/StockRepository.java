package com.example.SimpleInvest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SimpleInvest.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, String> {
}