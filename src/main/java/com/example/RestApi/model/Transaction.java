package com.example.RestApi.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "transactions")

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "account_number", nullable = false)
    private String accountNumber;


    @Column(name = "trx_amount", nullable = false)
    private double trxAmount;


    @Column(name = "description", nullable = false)
    private String description;



    @Column(name = "trx_date", nullable = false)
    private LocalDate trxDate;



    @Column(name = "trx_time", nullable = false)
    private LocalTime trxTime;


    @Column(name = "customer_id", nullable = false)
    private String customerId;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getTrxAmount() {
        return trxAmount;
    }

    public void setTrxAmount(double trxAmount) {
        this.trxAmount = trxAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(LocalDate trxDate) {
        this.trxDate = trxDate;
    }

    public LocalTime getTrxTime() {
        return trxTime;
    }

    public void setTrxTime(LocalTime trxTime) {
        this.trxTime = trxTime;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}

