package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.request.AgendaRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.AgendaResponseDTO;

import java.util.List;

public interface IAgendaService {
    AgendaResponseDTO save(AgendaRequestDTO dto);
    AgendaResponseDTO update(Long id, AgendaRequestDTO dto);
    List<AgendaResponseDTO> getAll();
    AgendaResponseDTO getById(Long id);
    void delete(Long id);
}

