package com.savio.project.coronavirus.mapper;

import com.savio.project.coronavirus.DTO.PacienteDTO;
import com.savio.project.coronavirus.model.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface PacienteMapper {

    PacienteMapper INSTANCE = Mappers.getMapper(PacienteMapper.class);

    Paciente toModel(PacienteDTO pacienteDTO);

    PacienteDTO toDTO(Paciente paciente);

}
