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
public class SubcategoryActivityRequest {

    @NotBlank(message = "El nombre de la subcategoría es obligatorio")
    private String name;

    private String description;

    @NotNull(message = "El estado de la subcategoría es obligatorio")
    private Boolean status;

    @NotNull(message = "El ID de la categoría es obligatorio")
    private Long categoryId;
}
