package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.entity.Roles;

import java.util.List;

public interface IRolesService {
    Roles saveRoles(Roles roles);
    Roles updateRoles(Long id, Roles roles);
    List<Roles> getAllRoles();
    Roles getRolesById(Long id);
    void deleteRoles(Long id);
}
