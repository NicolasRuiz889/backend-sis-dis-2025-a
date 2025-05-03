package com.corhuila.backend_sis_dis_2025_a.entity;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "subjects")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura")
    private Long id;

    @Column(name = "nombre_asignatura", nullable = false)
    private String name;

    @Column(name = "hora_semanal", nullable = false)
    private Integer weeklyHours;

    @Column(name = "hora_semestral", nullable = false)
    private Integer semesterHours;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "programa_id", nullable = false)
    private Program program;

}

