// src/main/java/com/corhuila/backend_sis_dis_2025_a/service/impl/SubcategoryActivityServiceImpl.java
package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.request.SubcategoryActivityRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.SubcategoryActivityResponse;
import com.corhuila.backend_sis_dis_2025_a.entity.Category;
import com.corhuila.backend_sis_dis_2025_a.entity.SubcategoryActivity;
import com.corhuila.backend_sis_dis_2025_a.repository.CategoryRepository;
import com.corhuila.backend_sis_dis_2025_a.repository.SubcategoryActivityRepository;
import com.corhuila.backend_sis_dis_2025_a.service.ISubcategoryActivityService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubcategoryActivityServiceImpl implements ISubcategoryActivityService {

    private final SubcategoryActivityRepository repo;
    private final CategoryRepository categoryRepo;

    private SubcategoryActivity toEntity(SubcategoryActivityRequest request) {
        Category category = categoryRepo.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        return SubcategoryActivity.builder()
                .name(request.getName())
                .description(request.getDescription())
                .status(request.getStatus())
                .category(category)
                .build();
    }

    private SubcategoryActivityResponse toResponse(SubcategoryActivity entity) {
        return SubcategoryActivityResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .status(entity.getStatus())
                .categoryId(entity.getCategory().getId())
                .categoryName(entity.getCategory().getName())
                .build();
    }

    @Override
    public SubcategoryActivityResponse create(SubcategoryActivityRequest request) {
        return toResponse(repo.save(toEntity(request)));
    }

    @Override
    public SubcategoryActivityResponse update(Long id, SubcategoryActivityRequest request) {
        SubcategoryActivity entity = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Subcategory not found"));

        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setStatus(request.getStatus());
        entity.setCategory(categoryRepo.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found")));

        return toResponse(repo.save(entity));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    @Transactional
    public SubcategoryActivityResponse findById(Long id) {
        return repo.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Subcategory not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<SubcategoryActivityResponse> findAll() {
        return repo.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}

