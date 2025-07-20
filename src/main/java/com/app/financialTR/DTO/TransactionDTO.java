package com.app.financialTR.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull
    private Long cdTypeValue;

    @NotBlank
    @Size(min = 1, max = 50)
    private String description;

    @NotNull
    @Min(0)
    private BigDecimal amount;

    @NotNull
    private Long cdCategory;
}
