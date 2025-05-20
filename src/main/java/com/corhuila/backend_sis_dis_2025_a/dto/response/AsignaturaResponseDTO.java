package com.corhuila.backend_sis_dis_2025_a.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AsignaturaResponseDTO {
    private Long idAsignatura;
    private String nombreAsignatura;
    private Integer horaSemanal;
    private Integer horaSemestre;
    private String programaNombre;
}
