package com.app.financialTR.controller;

import com.app.financialTR.DTO.TransactionDTO;
import com.app.financialTR.model.Transaction;
import com.app.financialTR.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "api/FTR")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping(value = "/transaction/save")
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionDTO addNewTransaction(@RequestBody TransactionDTO trasactionDTO) {

        return transactionService.addTransaction(trasactionDTO);
    }

    @GetMapping(value = "/transactions")
    @ResponseStatus(HttpStatus.OK)
    public List<Transaction> getAllTransactions() {

        return transactionService.getAllTransactions();
    }

    @GetMapping(value = "/transactions/typeValue/{cdTypeValue}")
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionDTO> getTransactionsByType(@PathVariable Long cdTypeValue) {

        return transactionService.getTransactionsByCdTypeValue(cdTypeValue);
    }

    @GetMapping(value = "/transactions/period")
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionDTO> getTransactionsByPeriod(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {

        return transactionService.getTransactionsByPeriod(startDate, endDate);
    }
    @GetMapping(value = "/transactions/category/{cdCategory}")
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionDTO> getTransactionsByCategory(@PathVariable Long cdCategory) {

        return transactionService.getTransactionsByCategory(cdCategory);
    }

    @GetMapping(value = "/transactions/get-balance")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal getTransactionBalance() {
        return transactionService.getTotalBalance();
    }

}
