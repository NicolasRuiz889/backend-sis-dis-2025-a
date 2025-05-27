package com.corhuila.backend_sis_dis_2025_a.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {
    @NotBlank
    private String username;
    @NotBlank
    @Size(min = 4)
    private String password;
    @NotNull
    private Boolean enabled;
    @NotNull
    private Long personId;
}

