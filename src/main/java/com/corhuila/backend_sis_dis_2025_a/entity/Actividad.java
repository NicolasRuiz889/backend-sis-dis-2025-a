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
@Table(name = "actividad")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idActividad"
)
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
