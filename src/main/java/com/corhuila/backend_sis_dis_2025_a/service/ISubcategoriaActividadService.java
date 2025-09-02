package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.request.SubcategoriaActividadRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.SubcategoriaActividadResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.SubcategoriaActividad;

import java.util.List;

public interface ISubcategoriaActividadService {
    SubcategoriaActividadResponseDTO save(SubcategoriaActividadRequestDTO dto);
    SubcategoriaActividadResponseDTO update(Long id, SubcategoriaActividadRequestDTO dto);
    List<SubcategoriaActividadResponseDTO> getAll();
    SubcategoriaActividadResponseDTO getById(Long id);
    void delete(Long id);
    SubcategoriaActividad getSubcategoriaByIdEntity(Long id);
}
