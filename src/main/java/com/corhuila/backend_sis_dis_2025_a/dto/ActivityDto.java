package com.corhuila.backend_sis_dis_2025_a.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityDto {
    private Long id;
    private String name;
    private Integer weeklyHours;
    private Integer semesterHours;
    private String description;
    private String product;
    private String status;
    private Long subcategoryId;
}
