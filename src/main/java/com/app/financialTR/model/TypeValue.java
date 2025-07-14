package com.app.financialTR.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeValue {

    @Column(name="cd_type_value")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdTypeValue;

    @Column(name="nm_type_value")
    private String nmTypeValue;

    //vou conseguir listar transaçoes por tipos
    @OneToMany(mappedBy = "cdTypeValue")
    private List<Transaction> transactions = new ArrayList<>();





}
