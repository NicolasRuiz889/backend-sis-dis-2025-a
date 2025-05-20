package com.corhuila.backend_sis_dis_2025_a.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoVinculacionResponseDTO {
    private Long idVinculacion;
    private String nombreVinculacion;
    private Integer horasMin;
    private Integer horasMax;
}
