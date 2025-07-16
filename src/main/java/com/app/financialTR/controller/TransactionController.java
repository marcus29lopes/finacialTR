package com.app.financialTR.controller;

import com.app.financialTR.DTO.TransactionDTO;
import com.app.financialTR.model.Transaction;
import com.app.financialTR.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/FTR")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping(value = "/add-new-transaction")
    @ResponseStatus(HttpStatus.OK)
    public TransactionDTO addNewTransaction(@RequestBody TransactionDTO dtoTransaction) {

        return transactionService.addTransaction(dtoTransaction);
    }

    @GetMapping(value = "/all-transactions")
    @ResponseStatus(HttpStatus.OK)
    public List<Transaction> getAllTransactions() {

        return transactionService.listAllTransactions();
    }

    @GetMapping(value = "/transaction/{cdTypeValue}")
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionDTO> getTransactionsByType(@PathVariable Long cdTypeValue) {

        return transactionService.listTransactionsByCdTypeValue(cdTypeValue);
    }



}
