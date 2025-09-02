package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.request.GrupoRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.GrupoResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.Asignatura;
import com.corhuila.backend_sis_dis_2025_a.entity.Grupo;
import com.corhuila.backend_sis_dis_2025_a.exception.ResourceNotFoundException;
import com.corhuila.backend_sis_dis_2025_a.repository.GrupoRepository;
import com.corhuila.backend_sis_dis_2025_a.service.IAsignaturaService;
import com.corhuila.backend_sis_dis_2025_a.service.IGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GrupoServiceImpl implements IGrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private IAsignaturaService asignaturaService;

    @Override
    public GrupoResponseDTO saveGrupo(GrupoRequestDTO dto) {
        Asignatura asignatura = asignaturaService.getAsignaturaByIdEntity(dto.getAsignaturaId());

        Grupo grupo = new Grupo();
        grupo.setNumeroGrupo(dto.getNumeroGrupo());
        grupo.setAsignatura(asignatura);

        return mapToResponse(grupoRepository.save(grupo));
    }

    @Override
    public GrupoResponseDTO updateGrupo(Long id, GrupoRequestDTO dto) {
        Grupo grupo = getGrupoByIdEntity(id);
        Asignatura asignatura = asignaturaService.getAsignaturaByIdEntity(dto.getAsignaturaId());

        grupo.setNumeroGrupo(dto.getNumeroGrupo());
        grupo.setAsignatura(asignatura);

        return mapToResponse(grupoRepository.save(grupo));
    }

    @Override
    public List<GrupoResponseDTO> getAllGrupos() {
        return grupoRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public GrupoResponseDTO getGrupoById(Long id) {
        return mapToResponse(getGrupoByIdEntity(id));
    }

    @Override
    public void deleteGrupo(Long id) {
        grupoRepository.delete(getGrupoByIdEntity(id));
    }

    public Grupo getGrupoByIdEntity(Long id) {
        return grupoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Grupo", "id", id));
    }

    private GrupoResponseDTO mapToResponse(Grupo grupo) {
        GrupoResponseDTO dto = new GrupoResponseDTO();
        dto.setIdGrupo(grupo.getIdGrupo());
        dto.setNumeroGrupo(grupo.getNumeroGrupo());
        dto.setAsignaturaNombre(grupo.getAsignatura() != null ? grupo.getAsignatura().getNombreAsignatura() : null);
        return dto;
    }

}
