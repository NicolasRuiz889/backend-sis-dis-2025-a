package com.corhuila.backend_sis_dis_2025_a.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubcategoriaActividadRequestDTO {
    private String nombreSubcategoria;
    private String descripcion;
    private String estado;
    private Long categoriaId;
}
