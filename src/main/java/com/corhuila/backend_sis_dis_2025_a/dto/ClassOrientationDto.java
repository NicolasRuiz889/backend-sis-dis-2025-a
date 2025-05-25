package com.corhuila.backend_sis_dis_2025_a.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassOrientationDto {

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
    /*private String categoryName;
    private Long subcategoryId;
    private String subcategoryName;*/

    
    
}
