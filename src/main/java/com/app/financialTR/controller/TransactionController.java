package com.app.financialTR.controller;

import com.app.financialTR.model.Transaction;
import com.app.financialTR.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/FTR")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping(value = "/add-new-transaction")
    @ResponseStatus(HttpStatus.OK)
    public Transaction addNewTransaction(@RequestBody Transaction transaction) {

        return transactionService.addTransaction(transaction);
    }
}
