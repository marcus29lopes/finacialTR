package com.app.financialTR.service;

import com.app.financialTR.DTO.TransactionDTO;
import com.app.financialTR.exceptions.ResourceNotFoundException;
import com.app.financialTR.mapper.TransactionMapper;
import com.app.financialTR.model.Category;
import com.app.financialTR.model.Transaction;
import com.app.financialTR.model.TypeValue;
import com.app.financialTR.repository.TransactionRepository;
import com.app.financialTR.repository.TypeValueRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.app.financialTR.utils.PageableUtils.getPageable;

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
                .orElseThrow(() -> new ResourceNotFoundException("TypeValue", dtoTransaction.getCdTypeValue()));

        Category categoryTransaction = categoryService.findById(dtoTransaction.getCdCategory())
                .orElseThrow(() -> new ResourceNotFoundException("Category", dtoTransaction.getCdCategory()));

        Transaction newTransaction = transactionMapper.toEntity(dtoTransaction);
        newTransaction.setTypeValue(typeValueTransaction);
        newTransaction.setCdCategory(categoryTransaction);

        transactionRepository.save(newTransaction);

        return transactionMapper.toDTO(newTransaction);
    }


    public List<TransactionDTO> getAllTransactions(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
        Pageable pageDetails = getPageable(pageNumber, pageSize, sortBy, sortOrder);
        Page<Transaction> pageProducts = transactionRepository.findAll(pageDetails);

        List<Transaction> transactions = pageProducts.getContent();

        return transactions.stream()
                .map(transaction -> transactionMapper.toDTO(transaction))
                .toList();


    }

    public List<TransactionDTO> getTransactionsByCdTypeValue(Long cdTypeValue, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
        Pageable pageDetails = getPageable(pageNumber, pageSize, sortBy, sortOrder);
        Page<Transaction> pageTransactions = transactionRepository.findTransactionsByTypeValue(cdTypeValue, pageDetails);

        List<Transaction> transactions = pageTransactions.getContent();

        return transactions.stream()
                .map(transaction -> transactionMapper.toDTO(transaction))
                .toList();
    }

    public List<TransactionDTO> getTransactionsByPeriod(LocalDateTime startDate, LocalDateTime endDate, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
        Pageable pageDetails = getPageable(pageNumber, pageSize, sortBy, sortOrder);
        Page<Transaction> pageTransactions = transactionRepository.findTransactionByDateTimeBetween(startDate, endDate, pageDetails);

        List<Transaction> transactionList = pageTransactions.getContent();

        return transactionList.stream()
                .map(transaction -> transactionMapper.toDTO(transaction))
                .toList();

    }

    public List<TransactionDTO> getTransactionsByCategory(Long cdCategory, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
        Pageable pageDetails = getPageable(pageNumber, pageSize, sortBy, sortOrder);

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
