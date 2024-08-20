package com.example.RestApi.service;

import com.example.RestApi.model.Transaction;
import com.example.RestApi.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Page<Transaction> getTransactions(String accountNumber, String customerId, String description, Pageable pageable) {
        return transactionRepository.findByAccountNumberContainingOrCustomerIdContainingOrDescriptionContaining(
                accountNumber, customerId, description, pageable);
    }

    @Transactional
    public Transaction updateTransaction(Long id, String description) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow();
       transaction.setDescription(description);
        return transactionRepository.save(transaction);
    }
}

