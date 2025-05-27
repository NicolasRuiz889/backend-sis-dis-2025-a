package com.corhuila.backend_sis_dis_2025_a.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubcategoryActivityResponse {
    private Long id;
    private String name;
    private String description;
    private Boolean status;
    private Long categoryId;
    private String categoryName;
}

