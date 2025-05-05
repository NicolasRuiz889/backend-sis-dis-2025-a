package com.corhuila.backend_sis_dis_2025_a.entity;

import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "campuses")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Campus {

    @Id
    @Column(name = "campus_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(name = "campus_name", length = 50, nullable = false)
    private String name;

    @NotBlank(message = "La direccion es obligatoria")
    @Column(name = "address", length = 100 , nullable = false)
    private String address;

    @NotBlank(message = "El teléfono es obligatorio")
    @Column(name = "phone", length = 20, nullable = false)
    private String phone;

    @NotNull
    @Builder.Default
    @Column(name = "status", nullable = false)
    private Boolean status = true;
    
}
