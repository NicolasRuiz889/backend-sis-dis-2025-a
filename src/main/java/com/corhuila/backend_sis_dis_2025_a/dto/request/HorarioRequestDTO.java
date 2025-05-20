package com.corhuila.backend_sis_dis_2025_a.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HorarioRequestDTO {
    private String diaSemana;
    private String horaInicio;
    private String horaFin;
    private Long grupoId;
}
