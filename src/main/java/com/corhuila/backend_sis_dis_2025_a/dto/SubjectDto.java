package com.corhuila.backend_sis_dis_2025_a.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class SubjectDto {
    private Long id;
    private String name;
    private int weeklyHours;
    private int semesterHours;
    private Long programId;
}
