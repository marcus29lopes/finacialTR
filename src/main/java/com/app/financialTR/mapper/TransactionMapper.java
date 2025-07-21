package com.app.financialTR.mapper;

import com.app.financialTR.DTO.TransactionDTO;
import com.app.financialTR.model.Category;
import com.app.financialTR.model.Transaction;
import com.app.financialTR.model.TypeValue;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class TransactionMapper {

    public Transaction toEntity(TransactionDTO transactionDTO, TypeValue typeValueTransaction, Category categoryTransaction) {
        return Transaction.builder()
                .description(transactionDTO.getDescription())
                .dateTime(LocalDateTime.now())
                .amount(transactionDTO.getAmount())
                .category(categoryTransaction)
                .typeValue(typeValueTransaction)
                .build();
    }

    public TransactionDTO toDTO(Transaction transaction) {
        return TransactionDTO.builder()
                .cdTypeValue(transaction.getTypeValue().getCdTypeValue())
                .description(transaction.getDescription())
                .amount(transaction.getAmount())
                .cdCategory(transaction.getCategory().getCdCategory())
                .build();
    }

}