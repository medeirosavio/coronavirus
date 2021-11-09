package com.savio.project.coronavirus.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalDTO {

    private Long id;

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @NotEmpty
    private String endereco;

    @NotNull
    private Integer leitosUTI;

    @NotNull
    private Integer leitosEnfermaria;

    @NotNull
    private Integer ocupadosEnfermaria;

    @NotNull
    private Integer ocupadosUTI;

}
