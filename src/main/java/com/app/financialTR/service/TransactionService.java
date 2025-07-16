package com.app.financialTR.service;

import com.app.financialTR.DTO.TransactionDTO;
import com.app.financialTR.mapper.TransactionMapper;
import com.app.financialTR.model.Transaction;
import com.app.financialTR.model.TypeValue;
import com.app.financialTR.repository.TransactionRepository;
import com.app.financialTR.repository.TypeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

        TypeValue typeValueTransaction = typeValueRepository.findById(dtoTransaction.getCdTypeValue())
                .orElseThrow(() -> new RuntimeException("Type Value Not Found"));

        Transaction newTransaction = transactionMapper.toEntity(dtoTransaction, typeValueTransaction);

        transactionRepository.save(newTransaction);

        return transactionMapper.toDTO(newTransaction);
    }

    public List<Transaction> listAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<TransactionDTO> listTransactionsByCdTypeValue(Long cdTypeValue) {
        List<Transaction> transactionList = transactionRepository.findByCdTypeValue_CdTypeValue(cdTypeValue);

        if (transactionList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma transação encontrada");
        }

        return transactionList.stream()
                .map( transaction -> transactionMapper.toDTO(transaction))
                        .toList();

    }
}
