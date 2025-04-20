package com.corhuila.backend_sis_dis_2025_a.entity;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalTime;



@Entity
@Table(name = "horario")
@Data   
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class Schedule {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "day_of_week", nullable = false)
    private String dayOfWeek;

@Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
}
