package com.corhuila.backend_sis_dis_2025_a.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassOrientationResponse {
    private Long id;
    private Long subjectId;
    private String subjectName;
    private Long programId;
    private String programName;
    private Long groupId;
    private String groupName;
    private Long campusId;
    private String campusName;
    private Integer weeklyHours;
    private Integer semesterHours;
}
