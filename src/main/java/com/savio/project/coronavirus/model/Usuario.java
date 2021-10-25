package com.savio.project.coronavirus.model;

import util.Auditoria;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Usuario extends Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false , length = 100)
    private String nome;

    @Column(nullable = false)
    private int idade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sexo sexo;

    @Column(nullable = false , unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDate dataIngresso;

}
