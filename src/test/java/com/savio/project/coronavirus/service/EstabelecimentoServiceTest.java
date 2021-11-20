package com.savio.project.coronavirus.service;

import com.savio.project.coronavirus.DTO.HospitalDTO;
import com.savio.project.coronavirus.builder.HospitalDTOBuilder;
import com.savio.project.coronavirus.mapper.HospitalMapper;
import com.savio.project.coronavirus.model.Estabelecimento;
import com.savio.project.coronavirus.model.Hospital;
import com.savio.project.coronavirus.repository.EstabelecimentoRepository;
import com.savio.project.coronavirus.util.HospitalAlreadyExistsExecpetion;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.util.Optional;

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
        Mockito.when(estabelecimentoRepository.findByCnpj(expectedHospitalToCreateDTO.getCnpj())).thenReturn(Optional.empty());

        HospitalDTO createdHospitalDTO = estabelecimentoService.cadastrarHospital(expectedHospitalToCreateDTO);

        MatcherAssert.assertThat(createdHospitalDTO, Is.is(IsEqual.equalTo(expectedHospitalToCreateDTO)));
    }

    @Test
    void whenExistingEstabelecimentoIsInformedThenAnExceptionShouldBeThrown(){
        HospitalDTO expectedHospitalToCreateDTO = hospitalDTOBuilder.buildHospitalDTO();
        Hospital expectedCreatedHospital = hospitalMapper.toModel(expectedHospitalToCreateDTO);

        final OngoingStubbing<Optional<Estabelecimento>> optionalOngoingStubbing = Mockito.when(estabelecimentoRepository.findByCnpj(expectedHospitalToCreateDTO.getCnpj()))
                .thenReturn(Optional.of(expectedCreatedHospital));

        Assertions.assertThrows(HospitalAlreadyExistsExecpetion.class, () -> estabelecimentoService.cadastrarHospital(expectedHospitalToCreateDTO));
    }

}
