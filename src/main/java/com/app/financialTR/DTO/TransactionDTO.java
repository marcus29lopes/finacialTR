package com.app.financialTR.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    private Long cdTypeValue;
    private String description;
    private BigDecimal amount;
    private Long cdCategory;
}
