package com.corhuila.backend_sis_dis_2025_a.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalTime;

@Entity
@Table(name = "schedules")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dia_semana", nullable = false)
    private String dayOfWeek;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime startTime;

    @Column(name = "hora_fin", nullable = false)
    private LocalTime endTime;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_grupo", nullable = false)
    private Group group;
}
