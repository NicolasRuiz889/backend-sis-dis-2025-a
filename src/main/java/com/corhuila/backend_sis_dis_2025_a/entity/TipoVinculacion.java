package com.corhuila.backend_sis_dis_2025_a.entity;

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
