package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.request.RolesRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.RolesResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.Roles;
import com.corhuila.backend_sis_dis_2025_a.exception.ResourceNotFoundException;
import com.corhuila.backend_sis_dis_2025_a.repository.RolesRepository;
import com.corhuila.backend_sis_dis_2025_a.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RolesServiceImpl implements IRolesService {

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public RolesResponseDTO saveRoles(RolesRequestDTO dto) {
        Roles entity = new Roles();
        entity.setNombreRol(dto.getNombreRol());
        entity.setDescripcion(dto.getDescripcion());
        return mapToResponse(rolesRepository.save(entity));
    }

    @Override
    public RolesResponseDTO updateRoles(Long id, RolesRequestDTO dto) {
        Roles entity = getRolesByIdEntity(id);
        entity.setNombreRol(dto.getNombreRol());
        entity.setDescripcion(dto.getDescripcion());
        return mapToResponse(rolesRepository.save(entity));
    }

    @Override
    public List<RolesResponseDTO> getAllRoles() {
        return rolesRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public RolesResponseDTO getRolesById(Long id) {
        return mapToResponse(getRolesByIdEntity(id));
    }

    private Roles getRolesByIdEntity(Long id) {
        return rolesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Roles", "id", id));
    }

    @Override
    public void deleteRoles(Long id) {
        Roles roles = getRolesByIdEntity(id);
        rolesRepository.delete(roles);
    }

    @Override
    public Set<Roles> getRolesByIds(Set<Long> ids) {
        List<Roles> roles = rolesRepository.findAllById(ids);
        if (roles.size() != ids.size()) {
            throw new ResourceNotFoundException("Roles", "alguno de los ids", ids.toString());
        }
        return new HashSet<>(roles);
    }

    private RolesResponseDTO mapToResponse(Roles entity) {
        RolesResponseDTO dto = new RolesResponseDTO();
        dto.setIdRol(entity.getIdRol());
        dto.setNombreRol(entity.getNombreRol());
        dto.setDescripcion(entity.getDescripcion());
        return dto;
    }

}
