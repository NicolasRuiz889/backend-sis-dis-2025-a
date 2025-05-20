package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.request.AsignaturaRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.AsignaturaResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.Asignatura;

import java.util.List;

public interface IAsignaturaService {
    AsignaturaResponseDTO saveAsignatura(AsignaturaRequestDTO dto);
    AsignaturaResponseDTO updateAsignatura(Long id, AsignaturaRequestDTO dto);
    List<AsignaturaResponseDTO> getAllAsignaturas();
    AsignaturaResponseDTO getAsignaturaById(Long id);
    void deleteAsignatura(Long id);
    Asignatura getAsignaturaByIdEntity(Long id);
}
