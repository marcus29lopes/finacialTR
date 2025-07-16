package com.app.financialTR.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeValue {

    @Column(name="cd_type_value")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdTypeValue;

    @Column(name="nm_type_value")
    private String nmTypeValue;

    //vou conseguir listar transaçoes por tipos
    @OneToMany(mappedBy = "cdTypeValue")
    @JsonIgnore
    private List<Transaction> transactions = new ArrayList<>();





}
