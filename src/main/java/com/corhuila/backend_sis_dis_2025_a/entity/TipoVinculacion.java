package com.corhuila.backend_sis_dis_2025_a.entity;

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
@Table(name = "tipo_vinculacion")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idVinculacion"
)
public class TipoVinculacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVinculacion;
    private String nombreVinculacion;
    private Integer horasMin;
    private Integer horasMax;

    @OneToMany(mappedBy = "tipoVinculacion")
    private List<Persona> personas;

}
