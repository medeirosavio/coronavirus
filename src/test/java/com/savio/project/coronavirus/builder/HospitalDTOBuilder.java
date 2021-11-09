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
    private final Integer leitosUTI = 10 ;

    @Builder.Default
    private final Integer leitosEnfermaria = 20 ;

    @Builder.Default
    private final Integer ocupadosEnfermaria = 10;

    @Builder.Default
    private final Integer ocupadosUTI = 8;

    public HospitalDTO buildHospitalDTO(){

        return new HospitalDTO(id,nome,endereco,leitosUTI
                ,leitosEnfermaria,ocupadosUTI,ocupadosEnfermaria);
    }

}
