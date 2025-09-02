package com.corhuila.backend_sis_dis_2025_a.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class PersonaResponseDTO {
    private Long idPersona;
    private String nombre;
    private String apellido;
    private Date fechaFirma;
    private Boolean firmaDigital;
    private String estadoFirma;
    private String tipoVinculacionNombre;
    private Set<String> rolesNombres;
}
