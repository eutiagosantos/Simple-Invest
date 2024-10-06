package com.example.SimpleInvest.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "billing_tb")
@Getter
@Setter
public class BillingAddress {

    @Id
    @Column(name = "billing_id")
    private UUID billingId;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private int number;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "account_id")
    private Account account;

    public BillingAddress() {
    }

    public BillingAddress(UUID billingId, String street, int number, Account account) {
        this.billingId = billingId;
        this.street = street;
        this.number = number;
        this.account = account;
    }

}