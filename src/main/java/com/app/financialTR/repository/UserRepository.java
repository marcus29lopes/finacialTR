package com.app.financialTR.repository;

import com.app.financialTR.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByDsEmail(String userEmail);

    Boolean existsByDsEmail(String dsEmail);
}
