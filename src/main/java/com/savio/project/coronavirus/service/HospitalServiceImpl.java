package com.savio.project.coronavirus.service;

import com.savio.project.coronavirus.mapper.HospitalMapper;
import com.savio.project.coronavirus.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class HospitalServiceImpl {

    private static HospitalMapper hospitalMapper = HospitalMapper.INSTANCE;

    @Autowired
    HospitalRepository hospitalRepository;
}
