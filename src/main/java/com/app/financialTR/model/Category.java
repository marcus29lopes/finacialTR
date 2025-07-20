package com.app.financialTR.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

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

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(name = "nm_category")
    private String nmCategory;

    @OneToMany(mappedBy = "cdCategory")
    @JsonIgnore
    private List<Transaction> transactions;



}
