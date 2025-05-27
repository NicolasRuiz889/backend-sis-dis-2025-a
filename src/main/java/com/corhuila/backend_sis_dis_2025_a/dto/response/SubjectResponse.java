package com.corhuila.backend_sis_dis_2025_a.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubjectResponse {
    private Long id;
    private String code;
    private String name;
    private Integer credits;
    private String description;
    private Boolean status;
    private Long programId;
    private String programName;
}

