package com.corhuila.backend_sis_dis_2025_a.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "sede")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSede;

    @Column(name = "nombre_sede")
    private String nombreSede;

    @OneToMany(mappedBy = "sede", fetch = FetchType.EAGER)
    private List<Facultad> facultades;

}
