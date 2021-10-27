package com.savio.project.coronavirus.mapper;

import com.savio.project.coronavirus.DTO.PacienteDTO;
import com.savio.project.coronavirus.model.Paciente;
import org.mapstruct.factory.Mappers;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public interface PacienteMapper {

    PacienteMapper INSTANCE = Mappers.getMapper(PacienteMapper.class);

    Paciente toModel(PacienteDTO pacienteDTO);

    PacienteDTO toDTO(Paciente paciente);

}
