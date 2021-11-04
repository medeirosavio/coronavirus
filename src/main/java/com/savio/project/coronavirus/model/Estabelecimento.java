package com.savio.project.coronavirus.model;

import com.savio.project.coronavirus.util.Auditoria;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EqualsAndHashCode(exclude = {"nome","endereco","pacientes"},callSuper = false)
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
public abstract class Estabelecimento extends Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String endereco;

    @OneToMany(mappedBy = "estabelecimento" , fetch = FetchType.LAZY)
    private List<Paciente> pacientes;


    public Estabelecimento() {

    }
}
