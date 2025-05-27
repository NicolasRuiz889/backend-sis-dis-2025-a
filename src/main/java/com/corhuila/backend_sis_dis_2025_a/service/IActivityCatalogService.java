package com.corhuila.backend_sis_dis_2025_a.service;

import java.util.List;

import com.corhuila.backend_sis_dis_2025_a.dto.request.ActivityCatalogRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.ActivityCatalogResponse;


public interface IActivityCatalogService {
    ActivityCatalogResponse create(ActivityCatalogRequest request);
    ActivityCatalogResponse update(Long id, ActivityCatalogRequest request);
    void delete(Long id);
    ActivityCatalogResponse findById(Long id);
    List<ActivityCatalogResponse> findAll();
}

    

