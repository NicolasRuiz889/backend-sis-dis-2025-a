package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.request.ActividadRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.ActividadResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.Actividad;

import java.util.List;

public interface IActividadService {
    ActividadResponseDTO saveActividad(ActividadRequestDTO dto);
    ActividadResponseDTO updateActividad(Long id, ActividadRequestDTO dto);
    List<ActividadResponseDTO> getAllActividades();
    ActividadResponseDTO getActividadById(Long id);
    void deleteActividad(Long id);
    Actividad getByIdEntity(Long id);
}
