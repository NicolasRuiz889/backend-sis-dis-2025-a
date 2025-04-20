package com.corhuila.backend_sis_dis_2025_a.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "subject")  
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura")  
    private Long id;

    @Column(name = "nombre_asignatura")  
    private String name;

    @Column(name = "hora_semanal")  
    private int weeklyHours;  

    @Column(name = "hora_semestral")  
    private int semesterHours;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "programa_id")  
    private Program program;
}

