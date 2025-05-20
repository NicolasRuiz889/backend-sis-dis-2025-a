package com.corhuila.backend_sis_dis_2025_a.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubcategoriaActividadResponseDTO {
    private Long idSubcategoria;
    private String nombreSubcategoria;
    private String descripcion;
    private String estado;
    private String categoriaNombre;
}
