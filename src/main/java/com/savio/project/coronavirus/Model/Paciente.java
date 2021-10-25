package com.savio.project.coronavirus.Model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false , length = 100)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sexo sexo;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDate dataInicioSintomas;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false , unique = true)
    private long CPF;

    @Column(nullable = false)
    private boolean febre;

    @Column(nullable = false)
    private boolean cansaco;

    @Column(nullable = false)
    private boolean tosse;

    @Column(nullable = false)
    private boolean percaPaladar;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Hospital hospital;

}
