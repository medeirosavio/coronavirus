package com.savio.project.coronavirus.controllerdocs;

import com.savio.project.coronavirus.DTO.HospitalDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("Administrador management")
public interface AdministradorControllerDocs {

    @ApiOperation(value = "Hospital creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201,message = "Hospital Cadastrado com Sucesso"),
            @ApiResponse(code = 400, message = "Erro no cadastro do Hospital")
    })

    HospitalDTO cadastrarHospital(HospitalDTO hospitalDTO);

}
