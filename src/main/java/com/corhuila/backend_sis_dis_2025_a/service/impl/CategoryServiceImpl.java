// src/main/java/com/corhuila/backend_sis_dis_2025_a/service/impl/CategoryServiceImpl.java
package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.CategoryDto;
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

    private CategoryDto toDto(Category e) {
        return CategoryDto.builder()
                .id(e.getId())
                .name(e.getName())
                .description(e.getDescription())
                .status(e.getStatus())
                .build();
    }

    private Category toEntity(CategoryDto d) {
        return Category.builder()
                .id(d.getId())
                .name(d.getName())
                .description(d.getDescription())
                .status(d.getStatus())
                .build();
    }

    @Override public CategoryDto create(CategoryDto dto) {
        return toDto(repo.save(toEntity(dto)));
    }
    @Override public CategoryDto update(Long id, CategoryDto dto) {
        Category e = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        e.setName(dto.getName());
        e.setDescription(dto.getDescription());
        e.setStatus(dto.getStatus());
        return toDto(repo.save(e));
    }
    @Override public void delete(Long id) { repo.deleteById(id); }
    @Override public CategoryDto findById(Long id) {
        return repo.findById(id).map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }
    @Override public List<CategoryDto> findAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}



