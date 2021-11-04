package com.savio.project.coronavirus.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalDTO {

    @NotNull
    @NotEmpty
    private Long id;

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @NotEmpty
    private String endereco;

    @NotNull
    private int leitosUTI;

    @NotNull
    private int leitosEnfermaria;

}
