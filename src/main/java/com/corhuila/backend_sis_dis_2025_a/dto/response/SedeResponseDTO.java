package com.corhuila.backend_sis_dis_2025_a.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SedeResponseDTO {
    private Long idSede;
    private String nombreSede;
    private List<String> facultades;
}
