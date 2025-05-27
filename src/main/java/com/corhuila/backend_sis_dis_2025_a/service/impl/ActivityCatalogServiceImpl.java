package com.corhuila.backend_sis_dis_2025_a.service.impl;
import java.util.List;
import java.util.stream.Collectors;

import com.corhuila.backend_sis_dis_2025_a.dto.request.ActivityCatalogRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.ActivityCatalogResponse;
import org.springframework.stereotype.Service;

import com.corhuila.backend_sis_dis_2025_a.entity.ActivityCatalog;
import com.corhuila.backend_sis_dis_2025_a.repository.ActivityCatalogRepository;
import com.corhuila.backend_sis_dis_2025_a.service.IActivityCatalogService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ActivityCatalogServiceImpl implements IActivityCatalogService{

    private final ActivityCatalogRepository repo;

    private ActivityCatalog toEntity(ActivityCatalogRequest request) {
        return ActivityCatalog.builder()
                .name(request.getName())
                .build();
    }

    private ActivityCatalogResponse toResponse(ActivityCatalog entity) {
        return ActivityCatalogResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    @Override
    public ActivityCatalogResponse create(ActivityCatalogRequest request) {
        return toResponse(repo.save(toEntity(request)));
    }

    @Override
    public ActivityCatalogResponse update(Long id, ActivityCatalogRequest request) {
        ActivityCatalog entity = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity Catalog not found"));

        entity.setName(request.getName());
        return toResponse(repo.save(entity));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public ActivityCatalogResponse findById(Long id) {
        return repo.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Activity Catalog not found"));
    }

    @Override
    public List<ActivityCatalogResponse> findAll() {
        return repo.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
    
}
