package com.corhuila.backend_sis_dis_2025_a.entity;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "faculties")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Faculty {

    @Id
    @Column(name = "faculty_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "faculty_name",  nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;
    
    @Builder.Default
    @Column(name = "status", nullable = false)
    private Boolean status = true;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "campus_id", nullable = false)
    private Campus campus;

}
