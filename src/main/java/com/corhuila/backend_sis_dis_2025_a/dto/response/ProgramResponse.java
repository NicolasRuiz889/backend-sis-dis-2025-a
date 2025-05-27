package com.corhuila.backend_sis_dis_2025_a.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgramResponse {
    private Long id;
    private String code;
    private String name;
    private String modality;
    private String schedule;
    private Integer duration;
    private String degreeAwarded;
    private Boolean status;
    private Long facultyId;
    private String facultyName;
}

