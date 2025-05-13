package com.corhuila.backend_sis_dis_2025_a.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "horario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHorario;
    private String diaSemana;
    private String horaInicio;
    private String horaFin;

    @ManyToOne
    @JoinColumn(name = "idGrupo", referencedColumnName = "idGrupo")
    private Grupo grupo;

    @OneToMany(mappedBy = "horario")
    private List<Agenda> agendas;

}
