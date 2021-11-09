package com.savio.project.coronavirus.controller;


import com.savio.project.coronavirus.service.EstabelecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/administrador")
public class AdministradorController {

    @Autowired
    private EstabelecimentoService estabelecimentoService;



}
