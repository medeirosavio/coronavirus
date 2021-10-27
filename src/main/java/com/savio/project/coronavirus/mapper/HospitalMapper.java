package com.savio.project.coronavirus.mapper;

import com.savio.project.coronavirus.DTO.HospitalDTO;
import com.savio.project.coronavirus.model.Hospital;
import org.mapstruct.factory.Mappers;

public interface HospitalMapper {

    HospitalMapper INSTANCE = Mappers.getMapper(HospitalMapper.class);

    Hospital toModel(HospitalDTO hospitalDTO);

    HospitalDTO toDTO(Hospital hospital);

}
