package com.corhuila.backend_sis_dis_2025_a.entity;

import lombok.*;
import jakarta.persistence.Column;
import jakarta.persistence.*;

@Entity
@Table(name = "campuses")
@Data
@Builder

public class Campus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "campus_name", length = 50, nullable = false)
    private String name;
    
}
