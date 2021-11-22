package com.savio.project.coronavirus.controllerdocs;

import com.savio.project.coronavirus.DTO.UPADTO;
import com.savio.project.coronavirus.DTO.HospitalDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("Administrador Management")
public interface AdministradorControllerDocs {

    @ApiOperation(value = "UPA creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201,message = "UPA Cadastrado com Sucesso"),
            @ApiResponse(code = 400, message = "Erro no cadastro da UPA")
    })
    UPADTO cadastrarUPA(UPADTO upadto);

    @ApiOperation(value = "Hospital creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201,message = "Hospital Cadastrado com Sucesso"),
            @ApiResponse(code = 400, message = "Erro no cadastro do Hospital")
    })

    HospitalDTO cadastrarHospital(HospitalDTO hospitalDTO);

}
