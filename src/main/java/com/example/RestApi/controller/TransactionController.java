package com.example.RestApi.controller;

import com.example.RestApi.model.Transaction;
import com.example.RestApi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public ResponseEntity<Page<Transaction>> getTransactions(
            @RequestParam(required = false) String accountNumber,
            @RequestParam(required = false) String customerId,
            @RequestParam(required = false) String description,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Transaction> transactions = transactionService.getTransactions(accountNumber, customerId, description, pageable);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Transaction> updateTransaction(
            @PathVariable Long id, @RequestBody String description) {
        Transaction updatedTransaction = transactionService.updateTransaction(id, description);
        return new ResponseEntity<>(updatedTransaction, HttpStatus.OK);
    }
}
