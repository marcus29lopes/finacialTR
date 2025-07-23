package com.app.financialTR.controller;

import com.app.financialTR.DTO.TransactionDTO;
import com.app.financialTR.config.AppConstants;
import com.app.financialTR.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/FTR")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping(value = "/transaction/save")
    public ResponseEntity<TransactionDTO> addNewTransaction(@Valid @RequestBody TransactionDTO transactionDTO) {

        return new ResponseEntity<>(transactionService.addTransaction(transactionDTO), HttpStatus.CREATED);
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
    public ResponseEntity<List<TransactionDTO>> getTransactionsByPeriod(@RequestParam LocalDate startDate,
                                                                        @RequestParam LocalDate endDate) {

        return new ResponseEntity<>(transactionService.getTransactionsByPeriod(startDate, endDate), HttpStatus.OK);
    }

    @GetMapping(value = "/transactions/category/{cdCategory}")
    public ResponseEntity<List<TransactionDTO>> getTransactionsByCategory(@PathVariable Long cdCategory,
                                                                          @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
                                                                          @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
                                                                          @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_TRANSACTIONS_BY, required = false) String sortBy,
                                                                          @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIRECTION, required = false) String sortOrder) {

        return new ResponseEntity<>(transactionService.getTransactionsByCategory(cdCategory, pageNumber, pageSize, sortBy, sortOrder), HttpStatus.OK);
    }

    //soma todas entradas
    @GetMapping(value = "/transactions/get-balance")
    public ResponseEntity<BigDecimal> getTransactionBalance() {
        return new ResponseEntity<>(transactionService.getTotalBalance(), HttpStatus.OK);
    }

}
