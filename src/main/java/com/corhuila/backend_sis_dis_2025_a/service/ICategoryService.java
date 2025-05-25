package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.CategoryDto;
import java.util.List;

public interface ICategoryService {
    CategoryDto create(CategoryDto dto);
    CategoryDto update(Long id, CategoryDto dto);
    void delete(Long id);
    CategoryDto findById(Long id);
    List<CategoryDto> findAll();
}


