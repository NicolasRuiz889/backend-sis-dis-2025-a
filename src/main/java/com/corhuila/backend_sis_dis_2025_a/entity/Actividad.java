package com.corhuila.backend_sis_dis_2025_a.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "actividad")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActividad;
    private String nombreActividad;
    private Integer horaSemanal;
    private Integer horaSemestre;
    private String descripcion;
    private String producto;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "subcategoria_id", referencedColumnName = "idSubcategoria")
    private SubcategoriaActividad subcategoria;

    @OneToMany(mappedBy = "actividad")
    private List<Agenda> agendas;

}
