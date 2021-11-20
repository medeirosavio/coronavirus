package com.savio.project.coronavirus.repository;

import com.savio.project.coronavirus.model.Estabelecimento;
import com.savio.project.coronavirus.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento,Long> {

    Optional<Estabelecimento> findByCnpj(Long cnpj);
}
