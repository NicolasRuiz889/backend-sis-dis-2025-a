package com.corhuila.backend_sis_dis_2025_a.service;
import java.util.List;

import com.corhuila.backend_sis_dis_2025_a.dto.ProgramDto;

public interface IProgramService {
    ProgramDto create(ProgramDto dto);
    ProgramDto update(Long id, ProgramDto dto);
    void delete(Long id);
    ProgramDto findById(Long id);
    List<ProgramDto> findAll();
    
}
