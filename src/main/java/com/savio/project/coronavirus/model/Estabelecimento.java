package com.savio.project.coronavirus.model;

import com.savio.project.coronavirus.util.Auditoria;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Estabelecimento extends Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String endereco;

    @OneToMany(mappedBy = "estabelecimento" , fetch = FetchType.LAZY)
    private List<Paciente> pacientes;

    public Estabelecimento(String nome,String endereco){
        this.nome = nome;
        this.endereco = endereco;
        pacientes = new ArrayList<Paciente>();
    }

    public Estabelecimento() {
    }



}
