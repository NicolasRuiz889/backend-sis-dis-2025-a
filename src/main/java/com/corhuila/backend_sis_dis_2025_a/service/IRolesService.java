package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.request.RolesRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.RolesResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.Roles;

import java.util.List;
import java.util.Set;

public interface IRolesService {
    RolesResponseDTO saveRoles(RolesRequestDTO dto);
    RolesResponseDTO updateRoles(Long id, RolesRequestDTO dto);
    List<RolesResponseDTO> getAllRoles();
    RolesResponseDTO getRolesById(Long id);
    void deleteRoles(Long id);
    Set<Roles> getRolesByIds(Set<Long> ids);
}
