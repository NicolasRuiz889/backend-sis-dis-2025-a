package com.corhuila.backend_sis_dis_2025_a.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgendaRequestDTO {
    private Long personaId;
    private Long actividadId;
    private Long horarioId;
}
