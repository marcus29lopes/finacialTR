package com.app.financialTR.repository;

import com.app.financialTR.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM transaction " +
                    "WHERE cd_type_value = :cdTypeValue"
    )
    List<Transaction> getTransactionByTypeValue(Long cdTypeValue);

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
    List<Transaction> geTransactionsByCategory(Long cdCategory);
}
