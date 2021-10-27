package com.savio.project.coronavirus.controller;

import com.savio.project.coronavirus.builder.HospitalDTOBuilder;
import com.savio.project.coronavirus.mapper.HospitalMapper;
import com.savio.project.coronavirus.repository.HospitalRepository;
import com.savio.project.coronavirus.service.HospitalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableArgumentResolver;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@ExtendWith(MockitoExtension.class)
public class HospitalControllerTest {

    private MockMvc mockMvc;

    @Mock
    private HospitalRepository hospitalRepository;

    @InjectMocks
    private HospitalService hospitalController;

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
