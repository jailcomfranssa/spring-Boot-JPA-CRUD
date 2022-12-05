package br.com.masterClass.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "curso")
public class CursoMaterial {

    @Id
    @SequenceGenerator(
            name = "corso_material_sequence",
            sequenceName = "corso_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "corso_material_sequence"
    )
    private Long cursoMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "curso_id",
            referencedColumnName = "cursoId"
    )
    @JsonBackReference
    private Curso curso;
}
































