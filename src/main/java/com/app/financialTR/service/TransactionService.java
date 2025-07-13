package com.app.financialTR.service;

import com.app.financialTR.model.Transaction;
import com.app.financialTR.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public Transaction addTransaction(Transaction transaction) {
        transaction.setDateTime(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }
}
