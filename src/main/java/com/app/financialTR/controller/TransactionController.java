package com.app.financialTR.controller;

import com.app.financialTR.DTO.TransactionDTO;
import com.app.financialTR.config.AppConstants;
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
    public ResponseEntity<List<TransactionDTO>> getAllTransactions(@RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
                                                                   @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
                                                                   @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_TRANSACTIONS_BY, required = false) String sortBy,
                                                                   @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIRECTION, required = false) String sortOrder
    ) {

        return new ResponseEntity<>(transactionService.getAllTransactions(pageNumber, pageSize, sortBy, sortOrder), HttpStatus.OK);
    }

    @GetMapping(value = "/transactions/typeValue/{cdTypeValue}")
    public ResponseEntity<List<TransactionDTO>> getTransactionsByType(@PathVariable Long cdTypeValue,
                                                                      @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
                                                                      @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
                                                                      @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_TRANSACTIONS_BY, required = false) String sortBy,
                                                                      @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIRECTION, required = false) String sortOrder) {

        return new ResponseEntity<>(transactionService.getTransactionsByCdTypeValue(cdTypeValue, pageNumber, pageSize, sortBy, sortOrder), HttpStatus.OK);
    }

    @GetMapping(value = "/transactions/period")
    public ResponseEntity<List<TransactionDTO>> getTransactionsByPeriod(@RequestParam LocalDateTime startDate,
                                                                        @RequestParam LocalDateTime endDate,
                                                                        @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
                                                                        @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
                                                                        @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_TRANSACTIONS_BY, required = false) String sortBy,
                                                                        @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIRECTION, required = false) String sortOrder) {

        return new ResponseEntity<>(transactionService.getTransactionsByPeriod(startDate, endDate, pageNumber, pageSize, sortBy, sortOrder), HttpStatus.OK);
    }

    @GetMapping(value = "/transactions/category/{cdCategory}")
    public ResponseEntity<List<TransactionDTO>> getTransactionsByCategory(@PathVariable Long cdCategory,
                                                                          @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
                                                                          @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
                                                                          @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_TRANSACTIONS_BY, required = false) String sortBy,
                                                                          @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIRECTION, required = false) String sortOrder) {

        return new ResponseEntity<>(transactionService.getTransactionsByCategory(cdCategory, pageNumber, pageSize, sortBy, sortOrder), HttpStatus.OK);
    }

    @GetMapping(value = "/transactions/get-balance")
    public ResponseEntity<BigDecimal> getTransactionBalance() {
        return new ResponseEntity<>(transactionService.getTotalBalance(), HttpStatus.OK);
    }

}
