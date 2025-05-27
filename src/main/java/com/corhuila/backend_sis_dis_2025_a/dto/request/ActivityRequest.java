package com.corhuila.backend_sis_dis_2025_a.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityRequest {

    @NotNull
    private Long activityCatalogId;
    @NotNull
    private Integer weeklyHours;
    private String description;
    private Boolean status = true;
    @NotNull
    private Long subcategoryId;
    private List<ProductRequest> products;
}
