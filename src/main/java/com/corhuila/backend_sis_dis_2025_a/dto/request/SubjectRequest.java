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
public class SubjectRequest {

    @NotBlank(message = "El código de la materia es obligatorio")
    private String code;

    @NotBlank(message = "El nombre de la materia es obligatorio")
    private String name;

    @NotNull(message = "Los créditos son obligatorios")
    private Integer credits;

    @NotBlank(message = "La descripción es obligatoria")
    private String description;

    @NotNull(message = "El estado es obligatorio")
    private Boolean status;

    @NotNull(message = "El ID del programa es obligatorio")
    private Long programId;
}
