package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.request.RoleRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.RoleResponse;
import com.corhuila.backend_sis_dis_2025_a.entity.Role;
import com.corhuila.backend_sis_dis_2025_a.repository.IRoleRepository;
import com.corhuila.backend_sis_dis_2025_a.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {

    private final IRoleRepository repo;

    private Role toEntity(RoleRequest r) {
        return Role.builder().name(r.getName()).description(r.getDescription()).status(r.getStatus()).build();
    }

    private RoleResponse toResponse(Role r) {
        return RoleResponse.builder().id(r.getId()).name(r.getName())
                .description(r.getDescription()).status(r.getStatus()).build();
    }

    public RoleResponse create(RoleRequest r) { return toResponse(repo.save(toEntity(r))); }

    public RoleResponse update(Long id, RoleRequest r) {
        Role role = repo.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
        role.setName(r.getName());
        role.setDescription(r.getDescription());
        role.setStatus(r.getStatus());
        return toResponse(repo.save(role));
    }

    public void delete(Long id) { repo.deleteById(id); }

    public RoleResponse findById(Long id) {
        return repo.findById(id).map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Role not found"));
    }

    public List<RoleResponse> findAll() {
        return repo.findAll().stream().map(this::toResponse).collect(Collectors.toList());
    }
}

