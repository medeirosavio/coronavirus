package com.savio.project.coronavirus.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.hibernate.mapping.Subclass;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
public class Hospital extends Estabelecimento{

    @Column(nullable = false)
    private int leitosDisponiveis;

    @Column(nullable = false)
    private int leitosOcupados;


    public Hospital() {
        super();
    }
}
