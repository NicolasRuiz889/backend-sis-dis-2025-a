package com.corhuila.backend_sis_dis_2025_a.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgramRequest {

    @NotBlank(message = "El código del programa es obligatorio")
    private String code;

    @NotBlank(message = "El nombre del programa es obligatorio")
    private String name;

    private String modality;
    private String schedule;
    private Integer duration;
    private String degreeAwarded;

    @NotNull(message = "El estado del programa es obligatorio")
    private Boolean status;

    @NotNull(message = "El ID de la facultad es obligatorio")
    private Long facultyId;
}
