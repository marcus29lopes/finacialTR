package com.app.financialTR.repository;

import com.app.financialTR.model.TypeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeValueRepository extends JpaRepository<TypeValue, Long> {
}
