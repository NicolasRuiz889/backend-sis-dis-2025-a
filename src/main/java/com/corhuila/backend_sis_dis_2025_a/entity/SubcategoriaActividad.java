package com.corhuila.backend_sis_dis_2025_a.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "sub_categoria_actividad")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubcategoriaActividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubcategoria;
    private String nombreSubcategoria;
    private String descripcion;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "idCategoria")
    private Categoria categoria;

    @OneToMany(mappedBy = "subcategoria")
    private List<Actividad> actividades;

}
