package com.app.financialTR.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_category")
    private Long cdCategory;

    @Column(name = "nm_category")
    private String nmCategory;

    @OneToMany(mappedBy = "cdCategory")
    private List<Transaction> transactions;



}
