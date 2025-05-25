// src/main/java/com/corhuila/backend_sis_dis_2025_a/service/impl/SubcategoryActivityServiceImpl.java
package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.SubcategoryActivityDto;
import com.corhuila.backend_sis_dis_2025_a.entity.Category;
import com.corhuila.backend_sis_dis_2025_a.entity.SubcategoryActivity;
import com.corhuila.backend_sis_dis_2025_a.repository.CategoryRepository;
import com.corhuila.backend_sis_dis_2025_a.repository.SubcategoryActivityRepository;
import com.corhuila.backend_sis_dis_2025_a.service.ISubcategoryActivityService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubcategoryActivityServiceImpl implements ISubcategoryActivityService {

    private final SubcategoryActivityRepository repo;
    private final CategoryRepository catRepo;

    private SubcategoryActivityDto toDto(SubcategoryActivity e) {
        return SubcategoryActivityDto.builder()
                .id(e.getId())
                .name(e.getName())
                .description(e.getDescription())
                .status(e.getStatus())
                .categoryId(e.getCategory().getId())
                .build();
    }

    private SubcategoryActivity toEntity(SubcategoryActivityDto d) {
        Category cat = catRepo.findById(d.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return SubcategoryActivity.builder()
                .id(d.getId())
                .name(d.getName())
                .description(d.getDescription())
                .status(d.getStatus())
                .category(cat)
                .build();
    }

    @Override public SubcategoryActivityDto create(SubcategoryActivityDto dto) {
        return toDto(repo.save(toEntity(dto)));
    }
    @Override public SubcategoryActivityDto update(Long id, SubcategoryActivityDto dto) {
        SubcategoryActivity e = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Subcategory not found"));
        e.setName(dto.getName());
        e.setDescription(dto.getDescription());
        e.setStatus(dto.getStatus());
        e.setCategory(catRepo.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found")));
        return toDto(repo.save(e));
    }
    @Override public void delete(Long id) { repo.deleteById(id); }
    @Override public SubcategoryActivityDto findById(Long id) {
        return repo.findById(id).map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Subcategory not found"));
    }
    @Override public List<SubcategoryActivityDto> findAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}

