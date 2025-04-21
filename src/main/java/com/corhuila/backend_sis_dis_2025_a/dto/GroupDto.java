package com.corhuila.backend_sis_dis_2025_a.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupDto {
    private Long id;
    private String code;
    private Integer quota;
    private String status;
    
}
