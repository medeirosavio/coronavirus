package com.savio.project.coronavirus.mapper;

import com.savio.project.coronavirus.DTO.HospitalDTO;
import com.savio.project.coronavirus.model.Estabelecimento;
import com.savio.project.coronavirus.model.Hospital;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HospitalMapper {

    HospitalMapper INSTANCE = Mappers.getMapper(HospitalMapper.class);

    Hospital toModel(HospitalDTO hospitalDTO);

    HospitalDTO toDTO(Estabelecimento estabelecimento);

}
