package com.corhuila.backend_sis_dis_2025_a.entity;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "programs")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Program {

    @Id
    @Column(name = "program_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "program_code",  nullable = false , unique = true)
    private String code;

    @Column(name = "program_name",  nullable = false)
    private String name;

    @Column(name = "modality")
    private String modality;

    @Column(name = "schedule")
    private String schedule;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "degree_awarded")
    private String degreeAwarded;

    @Builder.Default
    @Column(name = "status", nullable = false)
    private Boolean status = true;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "faculty_id", nullable = false)
    private Faculty faculty;


    
}
