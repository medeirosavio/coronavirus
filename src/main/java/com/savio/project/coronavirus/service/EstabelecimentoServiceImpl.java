package com.savio.project.coronavirus.service;

import com.savio.project.coronavirus.mapper.HospitalMapper;
import com.savio.project.coronavirus.repository.EstabelecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstabelecimentoServiceImpl {

    private static HospitalMapper hospitalMapper = HospitalMapper.INSTANCE;


}
