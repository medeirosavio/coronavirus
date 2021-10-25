package com.savio.project.coronavirus.repository;

import com.savio.project.coronavirus.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {
}
