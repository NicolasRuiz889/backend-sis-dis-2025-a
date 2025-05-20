package com.corhuila.backend_sis_dis_2025_a.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "persona")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idPersona"
)
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    private String nombre;
    private String apellido;
    private Date fechaFirma;
    private Boolean firmaDigital;
    private String estadoFirma;

    @ManyToOne
    @JoinColumn(name = "vinculacion_id", referencedColumnName = "idVinculacion")
    private TipoVinculacion tipoVinculacion;

    @ManyToMany
    @JoinTable(
            name = "persona_roles",
            joinColumns = @JoinColumn(name = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private Set<Roles> roles;

    @OneToMany(mappedBy = "persona")
    private List<Agenda> agendas;

}
