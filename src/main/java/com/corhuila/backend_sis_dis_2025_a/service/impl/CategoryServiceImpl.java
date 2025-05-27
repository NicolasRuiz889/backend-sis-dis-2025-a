// src/main/java/com/corhuila/backend_sis_dis_2025_a/service/impl/CategoryServiceImpl.java
package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.request.CategoryRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.CategoryResponse;
import com.corhuila.backend_sis_dis_2025_a.entity.Category;
import com.corhuila.backend_sis_dis_2025_a.repository.CategoryRepository;
import com.corhuila.backend_sis_dis_2025_a.service.ICategoryService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryRepository repo;

    private Category toEntity(CategoryRequest request) {
        return Category.builder()
                .name(request.getName())
                .description(request.getDescription())
                .status(request.getStatus())
                .build();
    }

    private CategoryResponse toResponse(Category entity) {
        return CategoryResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .status(entity.getStatus())
                .build();
    }

    @Override
    public CategoryResponse create(CategoryRequest request) {
        return toResponse(repo.save(toEntity(request)));
    }

    @Override
    public CategoryResponse update(Long id, CategoryRequest request) {
        Category category = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setName(request.getName());
        category.setDescription(request.getDescription());
        category.setStatus(request.getStatus());

        return toResponse(repo.save(category));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public CategoryResponse findById(Long id) {
        return repo.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public List<CategoryResponse> findAll() {
        return repo.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}



