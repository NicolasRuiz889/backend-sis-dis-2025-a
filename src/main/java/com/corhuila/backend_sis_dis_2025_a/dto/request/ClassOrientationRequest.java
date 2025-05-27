package com.corhuila.backend_sis_dis_2025_a.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassOrientationRequest {

    @NotNull
    private Long subjectId;
    @NotNull
    private Long programId;
    @NotNull
    private Long groupId;
    @NotNull
    private Long campusId;
    @NotNull
    private Integer weeklyHours;
    @NotNull
    private Integer semesterHours;
}
