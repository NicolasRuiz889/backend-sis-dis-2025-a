package com.corhuila.backend_sis_dis_2025_a.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgendaDto {
    private Long id;
    private Long personaId;
    private Long activityId;
    private Long horarioId;
}

