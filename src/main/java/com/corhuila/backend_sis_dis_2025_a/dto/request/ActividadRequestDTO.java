package com.corhuila.backend_sis_dis_2025_a.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActividadRequestDTO {
    private String nombreActividad;
    private Integer horaSemanal;
    private Integer horaSemestre;
    private String descripcion;
    private String producto;
    private String estado;
    private Long subcategoriaId;
}
