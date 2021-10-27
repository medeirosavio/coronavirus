package com.savio.project.coronavirus.DTO;

import com.savio.project.coronavirus.model.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDTO {

    @NotNull
    @NotEmpty
    private String nome;

    private Sexo sexo;

    @NotNull
    private LocalDate dataInicioSintomas;

    @NotNull
    @NotEmpty
    private LocalDate dataNascimento;

    @NotNull
    @NotEmpty
    private String endereco;

    @NotNull
    @NotEmpty
    private Long CPF;

    @NotNull
    private Boolean febre;

    @NotNull
    private Boolean cansaco;

    @NotNull
    private Boolean tosse;

    @NotNull
    private Boolean percaPaladar;
}
