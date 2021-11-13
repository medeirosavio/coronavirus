package com.savio.project.coronavirus.controller;


import com.savio.project.coronavirus.DTO.HospitalDTO;
import com.savio.project.coronavirus.controllerdocs.AdministradorControllerDocs;
import com.savio.project.coronavirus.service.EstabelecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/administrador")
public class AdministradorController implements AdministradorControllerDocs {

    @Autowired
    private EstabelecimentoService estabelecimentoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HospitalDTO cadastrarHospital(@RequestBody @Valid HospitalDTO hospitalDTO) {
        return estabelecimentoService.cadastrarHospital(hospitalDTO);
    }
}
