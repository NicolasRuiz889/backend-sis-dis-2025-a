package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.SubjectDto;
import java.util.List;

public interface ISubjectService {
    SubjectDto create(SubjectDto dto);
    SubjectDto update(Long id, SubjectDto dto);
    void delete(Long id);
    SubjectDto findById(Long id);
    List<SubjectDto> findAll();
}

