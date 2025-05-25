package com.corhuila.backend_sis_dis_2025_a.service.impl;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.corhuila.backend_sis_dis_2025_a.dto.ActivityCatalogDto;
import com.corhuila.backend_sis_dis_2025_a.entity.ActivityCatalog;
import com.corhuila.backend_sis_dis_2025_a.repository.ActivityCatalogRepository;
import com.corhuila.backend_sis_dis_2025_a.service.IActivityCatalogService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ActivityCatalogServiceImpl implements IActivityCatalogService{

    private final ActivityCatalogRepository repo;


    private ActivityCatalogDto toDto(ActivityCatalog e) {
        
        return ActivityCatalogDto.builder()
                .id(e.getId())
                .name(e.getName())
                .build();
    }
    private ActivityCatalog toEntity(ActivityCatalogDto d) {
        return ActivityCatalog.builder()
                .id(d.getId())
                .name(d.getName())
                .build();
    }

    @Override public ActivityCatalogDto create(ActivityCatalogDto dto) {
        return toDto(repo.save(toEntity(dto)));
    }

    @Override public ActivityCatalogDto update(Long id, ActivityCatalogDto dto) {
        ActivityCatalog e = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity Catalog not found"));
        e.setName(dto.getName());
        return toDto(repo.save(e));
    }

    @Override public void delete(Long id) {
         repo.deleteById(id);
         }

    @Override public ActivityCatalogDto findById(Long id) {
        return repo.findById(id).map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Activity Catalog not found"));
    }

    @Override public List<ActivityCatalogDto> findAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
    
}
