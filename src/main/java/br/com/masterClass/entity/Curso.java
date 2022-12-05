package br.com.masterClass.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Curso {

    @Id
    @SequenceGenerator(
            name = "corso_sequence",
            sequenceName = "curso_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "curso_sequence"
    )
    private Long cursoId;
    private String title;
    private Integer credit;

    @OneToOne(
            mappedBy = "curso"
    )
    @JsonManagedReference
    private CursoMaterial cursoMaterial;
}



































