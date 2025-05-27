package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.request.SubcategoryActivityRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.SubcategoryActivityResponse;

import java.util.List;

public interface ISubcategoryActivityService {
    SubcategoryActivityResponse create(SubcategoryActivityRequest request);
    SubcategoryActivityResponse update(Long id, SubcategoryActivityRequest request);
    void delete(Long id);
    SubcategoryActivityResponse findById(Long id);
    List<SubcategoryActivityResponse> findAll();
}

