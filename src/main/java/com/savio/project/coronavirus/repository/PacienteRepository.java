package com.savio.project.coronavirus.repository;

import com.savio.project.coronavirus.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public interface PacienteRepository extends JpaRepository<Paciente,Long> {
}
