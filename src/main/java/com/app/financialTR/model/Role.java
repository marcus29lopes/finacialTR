package com.app.financialTR.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_role")
    private Long cdRole;

    @Column(name = "nm_role")
    private String nmRole;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private List<User> users;

}
