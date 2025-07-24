package com.app.financialTR.repository;

import com.app.financialTR.model.Role;
import org.springframework.data.repository.Repository;

import java.util.List;
@org.springframework.stereotype.Repository
public interface RoleRepository extends Repository<Role, Long> {

    List<Role> findAll();

    Role findByCdRole(Long roleId);
}
