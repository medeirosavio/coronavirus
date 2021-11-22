package com.savio.project.coronavirus.builder;

import com.savio.project.coronavirus.DTO.UPADTO;
import lombok.Builder;

@Builder
public class UPADTOBuilder {

    @Builder.Default
    private final Long id = 3L;

    @Builder.Default
    private final Long cnpj = 100200000188L;

    @Builder.Default
    private final String nome = "RONALDO FENOMENO";

    @Builder.Default
    private final String endereco = "Neoquimica Arena";

    public UPADTO buildUPADTO() {

        return new UPADTO(id, cnpj, nome, endereco);
    }
}
