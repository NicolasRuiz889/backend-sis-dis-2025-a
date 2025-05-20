package com.corhuila.backend_sis_dis_2025_a.service;

import java.util.List;

import com.corhuila.backend_sis_dis_2025_a.dto.ActivityCatalogDto;


public interface IActivityCatalogService {

    ActivityCatalogDto create(ActivityCatalogDto dto);
    ActivityCatalogDto update(Long id, ActivityCatalogDto dto);
    void delete(Long id);
    ActivityCatalogDto findById(Long id);
    List<ActivityCatalogDto> findAll();
}

    

