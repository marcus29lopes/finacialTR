package com.app.financialTR.repository;

import com.app.financialTR.DTO.TransactionDTO;
import com.app.financialTR.model.Category;
import com.app.financialTR.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {


    List<Transaction> findByCdTypeValue_CdTypeValue(Long cdTypeValue);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM transaction " +
                    "WHERE date BETWEEN :startDate AND :endDate"
    )
    List<Transaction> getTransactionsByPeriod(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM transaction " +
                    "WHERE cd_category = :cdCategory"
    )
    List<Transaction> findTransactionByCdCategory(Long cdCategory);
}
