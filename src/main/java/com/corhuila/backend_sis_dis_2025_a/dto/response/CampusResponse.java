package com.corhuila.backend_sis_dis_2025_a.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CampusResponse {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private Boolean status;
}
