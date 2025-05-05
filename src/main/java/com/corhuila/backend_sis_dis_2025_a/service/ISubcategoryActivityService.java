package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.SubcategoryActivityDto;
import java.util.List;

public interface ISubcategoryActivityService {
    SubcategoryActivityDto create(SubcategoryActivityDto dto);
    SubcategoryActivityDto update(Long id, SubcategoryActivityDto dto);
    void delete(Long id);
    SubcategoryActivityDto findById(Long id);
    List<SubcategoryActivityDto> findAll();
}

