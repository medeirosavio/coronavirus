package com.savio.project.coronavirus.service;

import com.savio.project.coronavirus.DTO.HospitalDTO;
import com.savio.project.coronavirus.builder.HospitalDTOBuilder;
import com.savio.project.coronavirus.mapper.HospitalMapper;
import com.savio.project.coronavirus.model.Hospital;
import com.savio.project.coronavirus.repository.EstabelecimentoRepository;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EstabelecimentoServiceTest {

    private final HospitalMapper hospitalMapper = HospitalMapper.INSTANCE;

    @Mock
    private EstabelecimentoRepository estabelecimentoRepository;

    @InjectMocks
    private EstabelecimentoServiceImpl estabelecimentoService;

    private HospitalDTOBuilder hospitalDTOBuilder;

    @BeforeEach
    void setup(){
        hospitalDTOBuilder = HospitalDTOBuilder.builder().build();
    }

    @Test
    void whenNewHospitalIsInformedThenItShouldBeCreated(){
        HospitalDTO expectedHospitalToCreateDTO = hospitalDTOBuilder.buildHospitalDTO();
        Hospital expectedCreatedHospital = hospitalMapper.toModel(expectedHospitalToCreateDTO);

        Mockito.when(estabelecimentoRepository.save(expectedCreatedHospital)).thenReturn(expectedCreatedHospital);

        HospitalDTO createdHospitalDTO = estabelecimentoService.cadastrarHospital(expectedHospitalToCreateDTO);

        MatcherAssert.assertThat(createdHospitalDTO, Is.is(IsEqual.equalTo(expectedHospitalToCreateDTO)));
    }

}
