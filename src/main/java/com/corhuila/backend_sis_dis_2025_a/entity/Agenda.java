package com.corhuila.backend_sis_dis_2025_a.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "agenda")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idAgenda"
)
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
