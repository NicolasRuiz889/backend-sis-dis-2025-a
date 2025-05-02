package com.corhuila.backend_sis_dis_2025_a.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "grupo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_number")
    private String groupNumber;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;
}


