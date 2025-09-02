package com.corhuila.backend_sis_dis_2025_a.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgendaResponseDTO {
    private Long idAgenda;
    private String personaNombre;
    private String actividadNombre;
    private String horarioResumen;
}
