package com.corhuila.backend_sis_dis_2025_a.dto;
import java.util.List;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityDto {
    private Long id;
     private Long activityCatalogId;
    private String activityCatalogName;
    private Integer weeklyHours;
    private Integer semesterHours;
    private String description;
    private List<ProductDto> product;
    private Boolean status;
    private Long subcategoryId;
    private String subcategoryName;
   
}
