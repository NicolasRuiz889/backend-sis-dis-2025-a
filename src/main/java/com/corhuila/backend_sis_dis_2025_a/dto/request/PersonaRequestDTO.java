package com.corhuila.backend_sis_dis_2025_a.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class PersonaRequestDTO {
    private String nombre;
    private String apellido;
    private Date fechaFirma;
    private Boolean firmaDigital;
    private String estadoFirma;
    private Long tipoVinculacionId;
    private Set<Long> rolesIds;
}
