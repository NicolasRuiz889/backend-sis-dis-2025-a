package com.corhuila.backend_sis_dis_2025_a.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityResponse {
    private Long id;
    private String description;
    private Integer weeklyHours;
    private Integer semesterHours;
    private Boolean status;
    private Long activityCatalogId;
    private String activityCatalogName;
    private Long subcategoryId;
    private String subcategoryName;
    private String categoryName;
    private List<ProductResponse> products;
}
