package com.savio.project.coronavirus.service;

import com.savio.project.coronavirus.DTO.HospitalDTO;
import com.savio.project.coronavirus.DTO.UPADTO;
import com.savio.project.coronavirus.builder.HospitalDTOBuilder;
import com.savio.project.coronavirus.builder.UPADTOBuilder;
import com.savio.project.coronavirus.mapper.HospitalMapper;
import com.savio.project.coronavirus.mapper.UPAMapper;

import com.savio.project.coronavirus.model.Estabelecimento;

import com.savio.project.coronavirus.model.Hospital;
import com.savio.project.coronavirus.model.UPA;
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

    private final UPAMapper upaMapper = UPAMapper.INSTANCE;

    @Mock
    private EstabelecimentoRepository estabelecimentoRepository;

    @InjectMocks
    private EstabelecimentoServiceImpl estabelecimentoService;

    private HospitalDTOBuilder hospitalDTOBuilder;

    private UPADTOBuilder upadtoBuilder;

    @BeforeEach
    void setup(){
        hospitalDTOBuilder = HospitalDTOBuilder.builder().build();
        upadtoBuilder = UPADTOBuilder.builder().build();}

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
    void whenNewUPAlIsInformedThenItShouldBeCreated(){
        UPADTO expectedUPAToCreateDTO = upadtoBuilder.buildUPADTO();
        UPA expectedCreatedUPA = upaMapper.toModel(expectedUPAToCreateDTO);

        Mockito.when(estabelecimentoRepository.save(expectedCreatedUPA)).thenReturn(expectedCreatedUPA);

        UPADTO createdUPADTO = estabelecimentoService.cadastrarUPA(expectedUPAToCreateDTO);

        MatcherAssert.assertThat(createdUPADTO, Is.is(IsEqual.equalTo(expectedUPAToCreateDTO)));
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
