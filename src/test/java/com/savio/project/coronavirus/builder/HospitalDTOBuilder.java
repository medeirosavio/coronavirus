package com.savio.project.coronavirus.builder;

import com.savio.project.coronavirus.DTO.HospitalDTO;
import lombok.Builder;

@Builder
public class HospitalDTOBuilder {

    @Builder.Default
    private final Long id = 1L;

    @Builder.Default
    private final String nome = "Roger Krug Guedes";

    @Builder.Default
    private final String endereco = "Neoquimica Arena";

    @Builder.Default
    private int leitosUTI = 10 ;

    @Builder.Default
    private int leitosEnfermaria = 20 ;

    public HospitalDTO hospitalDTOBuilder(){
        return new HospitalDTO(id,nome,endereco,leitosUTI,leitosEnfermaria);
    }

}
