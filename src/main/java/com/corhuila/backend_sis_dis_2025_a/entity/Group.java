package com.corhuila.backend_sis_dis_2025_a.entity;



import org.apache.xerces.impl.xs.models.CMBuilder;

import jakarta.persistence.*;
import jakarta.persistence.Column;

import lombok.*;



@Entity
@Table(name = "groups")
@Data
CMBuilder


@AllArgsConstructor
@NoArgsConstructor

public class Group {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;


@Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
