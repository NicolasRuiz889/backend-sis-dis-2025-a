package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.request.FacultadRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.FacultadResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.Facultad;

import java.util.List;

public interface IFacultadService {
    FacultadResponseDTO saveFacultad(FacultadRequestDTO facultadDTO);
    FacultadResponseDTO updateFacultad(Long id, FacultadRequestDTO facultadDTO);
    List<FacultadResponseDTO> getAllFacultades();
    FacultadResponseDTO getFacultadById(Long id);
    void deleteFacultad(Long id);
    Facultad getFacultadByIdEntity(Long id);
}
