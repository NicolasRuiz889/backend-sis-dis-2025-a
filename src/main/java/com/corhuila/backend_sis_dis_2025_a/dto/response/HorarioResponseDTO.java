package com.corhuila.backend_sis_dis_2025_a.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HorarioResponseDTO {
    private Long idHorario;
    private String diaSemana;
    private String horaInicio;
    private String horaFin;
    private String grupoNombre;
}
