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
public class GroupRequest {

    @NotBlank(message = "El código del grupo es obligatorio")
    private String code;

    @NotBlank(message = "El periodo del grupo es obligatorio")
    private String period;

    @NotNull(message = "El estado del grupo es obligatorio")
    private Boolean status;

    @NotNull(message = "El ID de la materia es obligatorio")
    private Long subjectId;
}
