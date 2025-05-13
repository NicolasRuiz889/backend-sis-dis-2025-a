package com.corhuila.backend_sis_dis_2025_a.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "programa")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Programa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrograma;
    private String nombrePrograma;

    @ManyToOne
    @JoinColumn(name = "facultad_id", referencedColumnName = "idFacultad")
    private Facultad facultad;

    @OneToMany(mappedBy = "programa")
    private List<Asignatura> asignaturas;

}
