package com.corhuila.backend_sis_dis_2025_a.dto;

import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ProgramDto {
    private Long id;
    private String code;
    private String name;
    private String modality;
    private String schedule;
    private Integer duration;
    private String degreeAwarded;
    private Boolean status;
    private Long facultyId;
    
}
