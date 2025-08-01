package com.app.financialTR.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_transaction")
    private Long cdTransaction;

    @ManyToOne
    @JoinColumn(name = "cd_type_value")
    private TypeValue typeValue;

    @Column(name = "description")
    private String dsDescription;

    @Column(name = "date")
    private LocalDateTime dtDateTime;

    @Column(name = "amount")
    private BigDecimal vlAmount;

    @ManyToOne
    @JoinColumn(name = "cd_category")
    private Category category;




}
