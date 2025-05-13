package com.corhuila.backend_sis_dis_2025_a.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "facultad")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Facultad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacultad;
    private String nombreFacultad;

    @ManyToOne
    @JoinColumn(name = "sede_id", referencedColumnName = "idSede")
    private Sede sede;

    @OneToMany(mappedBy = "facultad")
    private List<Programa> programas;

}
