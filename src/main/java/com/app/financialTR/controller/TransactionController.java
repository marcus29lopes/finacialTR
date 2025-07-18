package com.app.financialTR.controller;

import com.app.financialTR.DTO.TransactionDTO;
import com.app.financialTR.model.Transaction;
import com.app.financialTR.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<TransactionDTO> addNewTransaction(@RequestBody TransactionDTO trasactionDTO) {

        return new ResponseEntity<>(transactionService.addTransaction(trasactionDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "/transactions")
    public ResponseEntity<List<Transaction>> getAllTransactions() {

        return new ResponseEntity<>(transactionService.getAllTransactions(), HttpStatus.OK);
    }

    @GetMapping(value = "/transactions/typeValue/{cdTypeValue}")
    public ResponseEntity<List<TransactionDTO>> getTransactionsByType(@PathVariable Long cdTypeValue) {

        return new ResponseEntity<>(transactionService.getTransactionsByCdTypeValue(cdTypeValue), HttpStatus.OK);
    }

    @GetMapping(value = "/transactions/period")
    public ResponseEntity<List<TransactionDTO>> getTransactionsByPeriod(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {

        return new ResponseEntity<>(transactionService.getTransactionsByPeriod(startDate, endDate), HttpStatus.OK);
    }
    @GetMapping(value = "/transactions/category/{cdCategory}")
    public ResponseEntity<List<TransactionDTO>> getTransactionsByCategory(@PathVariable Long cdCategory) {

        return new ResponseEntity<>(transactionService.getTransactionsByCategory(cdCategory), HttpStatus.OK);
    }

    @GetMapping(value = "/transactions/get-balance")
    public ResponseEntity<BigDecimal> getTransactionBalance() {
        return new ResponseEntity<>(transactionService.getTotalBalance(), HttpStatus.OK);
    }

}
