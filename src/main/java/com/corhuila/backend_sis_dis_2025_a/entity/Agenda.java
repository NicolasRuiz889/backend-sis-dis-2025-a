package com.corhuila.backend_sis_dis_2025_a.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "agenda")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgenda;

    @ManyToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "idPersona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "actividad_id", referencedColumnName = "idActividad")
    private Actividad actividad;

    @ManyToOne
    @JoinColumn(name = "horario_id", referencedColumnName = "idHorario")
    private Horario horario;
}
