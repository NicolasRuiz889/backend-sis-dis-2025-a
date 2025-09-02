package com.corhuila.backend_sis_dis_2025_a.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaResponseDTO {
    private Long idCategoria;
    private String nombreCategoria;
    private String descripcion;
    private String estado;
}
