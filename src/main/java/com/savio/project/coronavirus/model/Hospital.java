package com.savio.project.coronavirus.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Hospital extends Estabelecimento{


    @Column(nullable = false)
    private int leitosDisponiveis;

    @Column(nullable = false)
    private int leitosOcupados;

    public Hospital(String nome,String endereco,int leitosDisponiveis,int leitosOcupados){
        super(nome,endereco);
        this.leitosDisponiveis = leitosDisponiveis;
        this.leitosOcupados = leitosOcupados;
    }


    public Hospital() {

    }
}
