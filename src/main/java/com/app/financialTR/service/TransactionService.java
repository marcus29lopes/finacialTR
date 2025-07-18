package com.app.financialTR.service;

import com.app.financialTR.DTO.TransactionDTO;
import com.app.financialTR.mapper.TransactionMapper;
import com.app.financialTR.model.Category;
import com.app.financialTR.model.Transaction;
import com.app.financialTR.model.TypeValue;
import com.app.financialTR.repository.TransactionRepository;
import com.app.financialTR.repository.TypeValueRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
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

    @Autowired
    CategoryService categoryService;


    @Transactional
    public TransactionDTO addTransaction(TransactionDTO dtoTransaction) {

        TypeValue typeValueTransaction = typeValueRepository.findById(dtoTransaction.getCdTypeValue())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "TypeValue não encontrado: " + dtoTransaction.getCdTypeValue()));

        Category categoryTransaction = categoryService.findById(dtoTransaction.getCdCategory())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category não encontrado: " + dtoTransaction.getCdCategory()));

        Transaction newTransaction = transactionMapper.toEntity(dtoTransaction);
        newTransaction.setTypeValue(typeValueTransaction);
        newTransaction.setCdCategory(categoryTransaction);

        transactionRepository.save(newTransaction);

        return transactionMapper.toDTO(newTransaction);
    }


    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<TransactionDTO> getTransactionsByCdTypeValue(Long cdTypeValue) {
        List<Transaction> transactionList = transactionRepository.geTransactionsByTypeValue(cdTypeValue);

        if (transactionList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma transação encontrada");
        }

        return transactionList.stream()
                .map(transaction -> transactionMapper.toDTO(transaction))
                .toList();

    }

    public List<TransactionDTO> getTransactionsByPeriod(LocalDateTime startDate, LocalDateTime endDate) {

        List<Transaction> transactionList = transactionRepository.getTransactionsByPeriod(startDate, endDate);

        return transactionList.stream()
                .map(transaction -> transactionMapper.toDTO(transaction))
                .toList();

    }

    public List<TransactionDTO> getTransactionsByCategory(Long cdCategory) {

        List<Transaction> transactions = transactionRepository.geTransactionsByCategory(cdCategory);

        return transactions.stream()
                .map((Transaction transaction) -> transactionMapper.toDTO(transaction))
                .toList();
    }

    public BigDecimal getTotalBalance() {

        //traz todas transactions que e do tipo entrada e soma retornando um bigDecimal
        BigDecimal balance = transactionRepository.getTransactionByTypeValue(2L)
                .stream()
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return balance;
    }
}
