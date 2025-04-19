package com.corhuila.backend_sis_dis_2025_a.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubcategoryActivityDto {
    private Long id;
    private String name;
    private String description;
    private String status;
    private Long categoryId;
}
