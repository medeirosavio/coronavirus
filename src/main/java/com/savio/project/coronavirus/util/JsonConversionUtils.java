package com.savio.project.coronavirus.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.savio.project.coronavirus.DTO.HospitalDTO;
import com.savio.project.coronavirus.model.Hospital;

public class JsonConversionUtils {

    public static String asJsonString(HospitalDTO hospitalDTO){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            objectMapper.registerModules(new JavaTimeModule());

            return objectMapper.writeValueAsString(hospitalDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

}
