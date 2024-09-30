package com.example.SimpleInvest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "stock_tb")
@Getter
@Setter
public class Stock {

    @Id
    @Column(name = "stock_id")
    private UUID stockId;

    @Column(name = "description")
    private String description;

}