package com.savio.project.coronavirus.model;

import com.savio.project.coronavirus.util.Auditoria;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Hospital extends Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String endereco;

    @Column(columnDefinition = "integer default 0")
    private int leitosUTI;

    @Column(columnDefinition = "integer default 0")
    private int leitosEnfermaria;

    @OneToMany(mappedBy = "hospital" , fetch = FetchType.LAZY)
    private List<Paciente> pacientes;

}
