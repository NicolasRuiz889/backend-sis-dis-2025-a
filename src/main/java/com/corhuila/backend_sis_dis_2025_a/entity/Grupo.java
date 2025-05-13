package com.corhuila.backend_sis_dis_2025_a.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "grupo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGrupo;
    private String numeroGrupo;

    @ManyToOne
    @JoinColumn(name = "asignatura_id", referencedColumnName = "idAsignatura")
    private Asignatura asignatura;

    @OneToMany(mappedBy = "grupo")
    private List<Horario> horarios;

}
