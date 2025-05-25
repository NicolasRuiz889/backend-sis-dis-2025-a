package com.corhuila.backend_sis_dis_2025_a.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubjectDto {
    private Long id;
    private String code;
    private String name;
    private Integer credits;
    private String description;
    private Boolean status;
    private Long programId; // <- relación con Program
}

