package com.savio.project.coronavirus.mapper;

import com.savio.project.coronavirus.DTO.HospitalDTO;
import com.savio.project.coronavirus.DTO.UPADTO;
import com.savio.project.coronavirus.model.Hospital;
import com.savio.project.coronavirus.model.UPA;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UPAMapper {

    UPAMapper INSTANCE = Mappers.getMapper(UPAMapper.class);

    UPA toModel(UPADTO hospitalDTO);

    UPADTO toDTO(UPA hospital);

}
