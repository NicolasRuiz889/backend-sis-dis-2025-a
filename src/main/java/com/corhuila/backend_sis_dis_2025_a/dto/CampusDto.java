package com.corhuila.backend_sis_dis_2025_a.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CampusDto {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private Boolean status;
    
}
