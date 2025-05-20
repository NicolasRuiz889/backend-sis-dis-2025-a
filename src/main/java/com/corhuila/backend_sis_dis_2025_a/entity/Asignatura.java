package com.corhuila.backend_sis_dis_2025_a.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "asignatura")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idAsignatura"
)
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsignatura;
    private String nombreAsignatura;
    private Integer horaSemanal;
    private Integer horaSemestre;

    @ManyToOne
    @JoinColumn(name = "programa_id", referencedColumnName = "idPrograma")
    private Programa programa;

    @OneToMany(mappedBy = "asignatura")
    @JsonIgnore
    private List<Grupo> grupos;

}
