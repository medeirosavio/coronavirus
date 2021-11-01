package com.savio.project.coronavirus.service;

import com.savio.project.coronavirus.builder.HospitalDTOBuilder;
import com.savio.project.coronavirus.mapper.HospitalMapper;
import com.savio.project.coronavirus.repository.EstabelecimentoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EstabelecimentoServiceTest {

    private final HospitalMapper hospitalMapper = HospitalMapper.INSTANCE;

    @Mock
    private EstabelecimentoRepository estabelecimentoRepository;

    @InjectMocks
    private EstabelecimentoService estabelecimentoService;

    private HospitalDTOBuilder hospitalDTOBuilder;

    @BeforeEach
    void setup(){
        hospitalDTOBuilder = HospitalDTOBuilder.builder().build();
    }

}
