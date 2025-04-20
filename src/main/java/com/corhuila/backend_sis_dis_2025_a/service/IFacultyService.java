package com.corhuila.backend_sis_dis_2025_a.service;
import java.util.List;

import com.corhuila.backend_sis_dis_2025_a.dto.FacultyDto;

public interface IFacultyService {
    FacultyDto create(FacultyDto dto);
    FacultyDto update(Long id, FacultyDto dto);
    void delete(Long id);
    FacultyDto findById(Long id);
    List<FacultyDto> findAll();
}
