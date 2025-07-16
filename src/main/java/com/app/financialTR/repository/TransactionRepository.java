package com.app.financialTR.repository;

import com.app.financialTR.DTO.TransactionDTO;
import com.app.financialTR.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {


    List<Transaction> findByCdTypeValue_CdTypeValue(Long cdTypeValue);
}
