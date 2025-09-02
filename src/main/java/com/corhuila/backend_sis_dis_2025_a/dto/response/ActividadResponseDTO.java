package com.corhuila.backend_sis_dis_2025_a.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActividadResponseDTO {
    private Long idActividad;
    private String nombreActividad;
    private Integer horaSemanal;
    private Integer horaSemestre;
    private String descripcion;
    private String producto;
    private String estado;
    private String subcategoriaNombre;
}
