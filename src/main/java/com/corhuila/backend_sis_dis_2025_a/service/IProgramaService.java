package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.request.ProgramaRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.ProgramaResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.Programa;

import java.util.List;

public interface IProgramaService {
    ProgramaResponseDTO savePrograma(ProgramaRequestDTO dto);
    ProgramaResponseDTO updatePrograma(Long id, ProgramaRequestDTO dto);
    List<ProgramaResponseDTO> getAllProgramas();
    ProgramaResponseDTO getProgramaById(Long id);
    void deletePrograma(Long id);
    Programa getProgramaByIdEntity(Long id);
}
