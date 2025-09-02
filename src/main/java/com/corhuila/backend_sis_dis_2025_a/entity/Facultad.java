package com.corhuila.backend_sis_dis_2025_a.entity;

import com.fasterxml.jackson.annotation.*;
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
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idFacultad"
)
public class Facultad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacultad;
    private String nombreFacultad;

    @ManyToOne
    @JoinColumn(name = "sede_id", referencedColumnName = "idSede")
    private Sede sede;

    @OneToMany(mappedBy = "facultad", fetch = FetchType.EAGER)
    private List<Programa> programas;

}
