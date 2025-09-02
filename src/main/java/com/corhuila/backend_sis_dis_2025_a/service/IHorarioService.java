package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.request.HorarioRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.HorarioResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.Horario;

import java.util.List;

public interface IHorarioService {
    HorarioResponseDTO save(HorarioRequestDTO dto);
    HorarioResponseDTO update(Long id, HorarioRequestDTO dto);
    List<HorarioResponseDTO> getAll();
    HorarioResponseDTO getById(Long id);
    void delete(Long id);
    Horario getHorarioByIdEntity(Long id);
}
