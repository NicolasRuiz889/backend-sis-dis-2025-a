// src/main/java/com/corhuila/backend_sis_dis_2025_a/dto/CategoryDto.java
package com.corhuila.backend_sis_dis_2025_a.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {
    private Long id;
    private String name;
    private String description;
    private Boolean status;
}
