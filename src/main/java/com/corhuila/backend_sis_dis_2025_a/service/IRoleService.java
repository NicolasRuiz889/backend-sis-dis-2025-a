package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.request.RoleRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.RoleResponse;

import java.util.List;

public interface IRoleService {
    RoleResponse create(RoleRequest r);
    RoleResponse update(Long id, RoleRequest r);
    void delete(Long id);
    RoleResponse findById(Long id);
    List<RoleResponse> findAll();
}
