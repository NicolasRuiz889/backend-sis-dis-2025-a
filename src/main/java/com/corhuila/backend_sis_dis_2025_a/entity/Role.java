package com.corhuila.backend_sis_dis_2025_a.entity;
import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name", nullable = false, unique = true)
    @NotNull
    private String name;

    @Column(name = "role_description", nullable = false)
    private String description;

    @Builder.Default
    @Column(name = "status", nullable = false)
    private Boolean status = true;


    
}
