package com.example.RestApi.repository;


import com.example.RestApi.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Page<Transaction> findByAccountNumberContainingOrCustomerIdContainingOrDescriptionContaining(
            String accountNumber, String customerId, String description, Pageable pageable);
}

