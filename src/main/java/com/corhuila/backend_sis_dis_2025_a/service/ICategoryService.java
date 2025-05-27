package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.request.CategoryRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.CategoryResponse;

import java.util.List;

public interface ICategoryService {
    CategoryResponse create(CategoryRequest request);
    CategoryResponse update(Long id, CategoryRequest request);
    void delete(Long id);
    CategoryResponse findById(Long id);
    List<CategoryResponse> findAll();
}


