package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.request.SedeRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.SedeResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.Sede;

import java.util.List;

public interface ISedeService {
    SedeResponseDTO saveSede(SedeRequestDTO sedeDTO);
    SedeResponseDTO updateSede(Long id, SedeRequestDTO sedeDTO);
    List<SedeResponseDTO> getAllSedes();
    SedeResponseDTO getSedeById(Long id);
    void deleteSede(Long id);
    Sede getSedeByIdEntity(Long id);
}
