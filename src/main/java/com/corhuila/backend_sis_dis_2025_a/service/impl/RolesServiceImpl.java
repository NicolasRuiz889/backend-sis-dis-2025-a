package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.entity.Roles;
import com.corhuila.backend_sis_dis_2025_a.exception.ResourceNotFoundException;
import com.corhuila.backend_sis_dis_2025_a.repository.RolesRepository;
import com.corhuila.backend_sis_dis_2025_a.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements IRolesService {

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public Roles saveRoles(Roles roles) {
        if (roles.getNombreRol() == null || roles.getNombreRol().isEmpty()) {
            throw new IllegalArgumentException("El nombre del rol es obligatorio.");
        }
        return rolesRepository.save(roles);
    }

    @Override
    public Roles updateRoles(Long id, Roles roles) {
        Roles existingRoles = getRolesById(id);
        existingRoles.setNombreRol(roles.getNombreRol());
        existingRoles.setDescripcion(roles.getDescripcion());
        return rolesRepository.save(existingRoles);
    }

    @Override
    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    @Override
    public Roles getRolesById(Long id) {
        return rolesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Roles", "id", id));
    }

    @Override
    public void deleteRoles(Long id) {
        Roles roles = getRolesById(id);
        rolesRepository.delete(roles);
    }

}
