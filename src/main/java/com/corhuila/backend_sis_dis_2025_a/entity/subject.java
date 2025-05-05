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
    @Column(name = "id_subject")
    private Long id;

    @Column(name = "subject_code",  nullable = false , unique = true)
    private String code;

    @Column(name = "subject_name", nullable = false)
    private String name;

    @Column(name = "credits", nullable = false)
    private Integer credits;

    @Column(name = "description", nullable = false)
    private String description;

    @Builder.Default
    @Column(name = "status", nullable = false)
    private Boolean status = true;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "program_id", nullable = false)
    private Program program;

}

