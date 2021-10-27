package com.savio.project.coronavirus.service;

import com.savio.project.coronavirus.mapper.PacienteMapper;
import com.savio.project.coronavirus.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements PacienteService{

    private static PacienteMapper pacienteMapper = PacienteMapper.INSTANCE;

    @Autowired
    PacienteRepository pacienteRepository;



}
