package com.app.financialTR.model;
import com.app.financialTR.enumType.TransactionType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_transaction")
    private Long cdTransaction;

    @Column(name = "type")
    private TransactionType type;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private LocalDateTime dateTime;

    @Column(name = "amount")
    private BigDecimal amount;




}
