package com.app.financialTR.mapper;

import com.app.financialTR.DTO.TransactionDTO;
import com.app.financialTR.model.Transaction;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class TransactionMapper {

    public Transaction toEntity(TransactionDTO transactionDTO) {
        return Transaction.builder()
                .description(transactionDTO.getDescription())
                .dateTime(LocalDateTime.now())
                .amount(transactionDTO.getAmount())
                .build();
    }

    public TransactionDTO toDTO(Transaction transaction) {
        return TransactionDTO.builder()
                .cdTypeValue(transaction.getCdTypeValue().getCdTypeValue())
                .description(transaction.getDescription())
                .amount(transaction.getAmount())
                .cdCategory(transaction.getCdCategory().getCdCategory())
                .build();
    }

}