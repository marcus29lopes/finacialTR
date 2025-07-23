package com.app.financialTR.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_user")
    private Long cdUser;

    @Column(name = "ds_email")
    private String dsEmail;

    @Column(name = "ds_password")
    private String dsPassword;

    @Column(name = "nm_user")
    private String nmUser;

    @Column(name = "vl_balance")
    private BigDecimal vlBalance;

    @ManyToOne
    @JoinColumn(name = "cd_role")
    private Role role;


}
