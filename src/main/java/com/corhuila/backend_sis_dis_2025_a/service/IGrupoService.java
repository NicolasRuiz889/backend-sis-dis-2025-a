package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.request.GrupoRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.GrupoResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.Grupo;

import java.util.List;

public interface IGrupoService {
    GrupoResponseDTO saveGrupo(GrupoRequestDTO dto);
    GrupoResponseDTO updateGrupo(Long id, GrupoRequestDTO dto);
    List<GrupoResponseDTO> getAllGrupos();
    GrupoResponseDTO getGrupoById(Long id);
    void deleteGrupo(Long id);
    Grupo getGrupoByIdEntity(Long id);
}
