package com.app.financialTR.model;
import com.app.financialTR.enumType.TransactionType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdTransaction;

    private TransactionType type;

    private String description;

    private LocalDateTime dateTime;

    private BigDecimal amount;




}
