package com.savio.project.coronavirus.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.hibernate.mapping.Subclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
public class Hospital extends Estabelecimento{

    @Column
    private int leitosUTI;

    @Column
    private int leitosEnfermaria;

    @Column
    private int ocupadosEnfermaria;

    @Column
    private int ocupadosUTI;;


    public Hospital() {
        super();
    }
}
