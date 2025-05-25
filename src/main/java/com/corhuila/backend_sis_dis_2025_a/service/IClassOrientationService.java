package com.corhuila.backend_sis_dis_2025_a.service;

import java.util.List;


import org.springframework.stereotype.Service;


import com.corhuila.backend_sis_dis_2025_a.dto.ClassOrientationDto;

@Service

public interface IClassOrientationService {

    ClassOrientationDto create(ClassOrientationDto dto);
    ClassOrientationDto update(Long id, ClassOrientationDto dto);
    void delete(Long id);
    ClassOrientationDto findById(Long id);
    List<ClassOrientationDto> findAll();

    List<ClassOrientationDto> findByProfesorId(Long profesorId);
    
    
}
