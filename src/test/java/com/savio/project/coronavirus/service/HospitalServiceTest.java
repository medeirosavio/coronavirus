package com.savio.project.coronavirus.service;

import com.savio.project.coronavirus.DTO.HospitalDTO;
import com.savio.project.coronavirus.builder.HospitalDTOBuilder;
import com.savio.project.coronavirus.mapper.HospitalMapper;
import com.savio.project.coronavirus.repository.HospitalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HospitalServiceTest {

    private final HospitalMapper hospitalMapper = HospitalMapper.INSTANCE;

    @Mock
    private HospitalRepository hospitalRepository;

    @InjectMocks
    private HospitalService hospitalService;

    private HospitalDTOBuilder hospitalDTOBuilder;

    @BeforeEach
    void setup(){
        hospitalDTOBuilder = HospitalDTOBuilder.builder().build();
    }

}
