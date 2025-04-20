package com.corhuila.backend_sis_dis_2025_a.entity;


import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "subject")
@Data
@Builder

@AllArgsConstructor
@NoArgsConstructor

public class Subject {

    @Id
    @Column(name = "program_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 

@Column(name = "nombre_asignatura")
    private String name;

@Column(name = "hora_semanal")
    private String weeklyHours;

@Column(name = "hora_semestral")
    private int semesterHours;

@ManyToOne
@JoinColumn(name = "programa_id")
    private Program program;
}

