package com.app.financialTR.service;

import com.app.financialTR.DTO.TransactionDTO;
import com.app.financialTR.mapper.TransactionMapper;
import com.app.financialTR.model.Transaction;
import com.app.financialTR.model.TypeValue;
import com.app.financialTR.repository.TransactionRepository;
import com.app.financialTR.repository.TypeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    TypeValueRepository typeValueRepository;

    @Autowired
    TransactionMapper transactionMapper;



    public TransactionDTO addTransaction(TransactionDTO dtoTransaction) {
        Transaction newTransaction = transactionMapper.toEntity(dtoTransaction);
        newTransaction.setDateTime(LocalDateTime.now());

        TypeValue typeValueTransaction = typeValueRepository.findById(dtoTransaction.getCdTypeValue())
                .orElseThrow(() -> new RuntimeException("Type Value Not Found"));
        newTransaction.setCdTypeValue(typeValueTransaction);

        transactionRepository.save(newTransaction);

        return transactionMapper.toDto(newTransaction);
    }

    public List<Transaction> listAllTransactions() {
        return transactionRepository.findAll();
    }
}
