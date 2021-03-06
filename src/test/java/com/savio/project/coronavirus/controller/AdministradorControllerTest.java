package com.savio.project.coronavirus.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.savio.project.coronavirus.DTO.UPADTO;
import com.savio.project.coronavirus.builder.HospitalDTOBuilder;
import com.savio.project.coronavirus.builder.UPADTOBuilder;
import com.savio.project.coronavirus.repository.EstabelecimentoRepository;
import com.savio.project.coronavirus.DTO.HospitalDTO;
import com.savio.project.coronavirus.builder.HospitalDTOBuilder;
import com.savio.project.coronavirus.service.EstabelecimentoServiceImpl;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import static com.savio.project.coronavirus.util.JsonConversionUtils.asJsonString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class
AdministradorControllerTest {

    private MockMvc mockMvc;

    @Mock
    private EstabelecimentoServiceImpl estabelecimentoService;

    @InjectMocks
    private AdministradorController administradorController;



    private UPADTOBuilder upadtoBuilder;
    private HospitalDTOBuilder hospitalDTOBuilder;

    @BeforeEach
    void setup(){
        upadtoBuilder = UPADTOBuilder.builder().build();
        hospitalDTOBuilder = HospitalDTOBuilder.builder().build();
    

 
        mockMvc = MockMvcBuilders.standaloneSetup(administradorController).
                setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver()).
                setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    void whenUPAPOSTIsCalledThenStatusCreatedShouldBeReturned() throws Exception {
        UPADTO expectedCreatedUPADTO = upadtoBuilder.buildUPADTO();

        Mockito.when(estabelecimentoService.cadastrarUPA(expectedCreatedUPADTO))
                .thenReturn(expectedCreatedUPADTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/administrador")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(expectedCreatedUPADTO)))
                    .andExpect(MockMvcResultMatchers.status().isCreated())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(expectedCreatedUPADTO.getId().intValue())))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.cnpj", Is.is(expectedCreatedUPADTO.getCnpj())))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.nome", Is.is(expectedCreatedUPADTO.getNome())))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.endereco", Is.is(expectedCreatedUPADTO.getEndereco())));

    }


    @Test
    void whenUPAPOSTIsCalledWithoutBadRequestShouldBeInformed() throws Exception {
        UPADTO expectedCreatedUPADTO = upadtoBuilder.buildUPADTO();
        expectedCreatedUPADTO.setCnpj(null);
      
    @Test
    void whenHospitalPOSTIsCalledThenStatusCreatedShouldBeReturned() throws Exception {
        HospitalDTO expectedCreatedHospitalDTO = hospitalDTOBuilder.buildHospitalDTO();

        Mockito.when(estabelecimentoService.cadastrarHospital(expectedCreatedHospitalDTO))
                .thenReturn(expectedCreatedHospitalDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/administrador")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(expectedCreatedHospitalDTO)))
                    .andExpect(MockMvcResultMatchers.status().isCreated())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(expectedCreatedHospitalDTO.getId().intValue())))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.cnpj", Is.is(expectedCreatedHospitalDTO.getCnpj())))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.nome", Is.is(expectedCreatedHospitalDTO.getNome())))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.endereco", Is.is(expectedCreatedHospitalDTO.getEndereco())))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.leitosUTI", Is.is(expectedCreatedHospitalDTO.getLeitosUTI())))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.leitosEnfermaria", Is.is(expectedCreatedHospitalDTO.getLeitosEnfermaria())))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.ocupadosEnfermaria", Is.is(expectedCreatedHospitalDTO.getOcupadosEnfermaria())))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.ocupadosUTI", Is.is(expectedCreatedHospitalDTO.getOcupadosUTI())));

    }

    @Test
    void whenHospitalPOSTIsCalledWithoutBadRequestShouldBeInformed() throws Exception {
        HospitalDTO expectedCreatedHospitalDTO = hospitalDTOBuilder.buildHospitalDTO();
        expectedCreatedHospitalDTO.setCnpj(null);



        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/administrador")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(expectedCreatedHospitalDTO)))
                    .andExpect(MockMvcResultMatchers.status().isBadRequest());



    }


    private String asJsonString(UPADTO upadto)  {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            objectMapper.registerModules(new JavaTimeModule());

            return objectMapper.writeValueAsString(upadto);
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

}
