package com.savio.project.coronavirus.builder;

import com.savio.project.coronavirus.DTO.HospitalDTO;
import lombok.Builder;

@Builder
public class HospitalDTOBuilder {

    private final Long id = 1L;

    private final String nome = "Roger Krug Guedes";

    private final String endereco = "Neoquimica Arena";

    private int leitosUTI = 10 ;

    private int leitosEnfermaria = 20 ;

    public HospitalDTO hospitalDTOBuilder(){
        return new HospitalDTO(id,nome,endereco,leitosUTI,leitosEnfermaria);
    }

}
