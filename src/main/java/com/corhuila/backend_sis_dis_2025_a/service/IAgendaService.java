package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.AgendaDto;
import java.util.List;

public interface IAgendaService {
    AgendaDto create(AgendaDto dto);
    AgendaDto update(Long id, AgendaDto dto);
    void delete(Long id);
    AgendaDto findById(Long id);
    List<AgendaDto> findAll();
}

