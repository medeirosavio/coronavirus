package com.savio.project.coronavirus.controller;

import com.savio.project.coronavirus.builder.HospitalDTOBuilder;
import com.savio.project.coronavirus.repository.EstabelecimentoRepository;
import com.savio.project.coronavirus.service.EstabelecimentoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@ExtendWith(MockitoExtension.class)
public class EstabelecimentoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private EstabelecimentoRepository estabelecimentoRepository;

    @InjectMocks
    private EstabelecimentoService hospitalController;

    private HospitalDTOBuilder hospitalDTOBuilder;

    @BeforeEach
    void setup(){
        hospitalDTOBuilder = HospitalDTOBuilder.builder().build();
        mockMvc = MockMvcBuilders.standaloneSetup(hospitalController).
                setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver()).
                setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();
    }

}
