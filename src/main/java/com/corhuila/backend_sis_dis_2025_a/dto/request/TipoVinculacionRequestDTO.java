package com.corhuila.backend_sis_dis_2025_a.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoVinculacionRequestDTO {
    private String nombreVinculacion;
    private Integer horasMin;
    private Integer horasMax;
}
