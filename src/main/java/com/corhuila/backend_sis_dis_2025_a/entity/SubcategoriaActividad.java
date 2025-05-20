package com.corhuila.backend_sis_dis_2025_a.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idSubcategoria"
)
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
