package com.savio.project.coronavirus.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UPADTO {

    private Long id;

    @NotNull
    private Long cnpj;

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @NotEmpty
    private String endereco;

}
