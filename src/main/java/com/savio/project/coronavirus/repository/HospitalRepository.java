package com.savio.project.coronavirus.repository;

import com.savio.project.coronavirus.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital,Long> {
}
