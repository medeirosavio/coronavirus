package com.savio.project.coronavirus.model;

import com.savio.project.coronavirus.util.Auditoria;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Funcionario extends Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false , length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String setor;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDate dataAdmissao;

    @Column(nullable = false, length = 100)
    private String cargo;

}
