package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.ActivityDto;
import com.corhuila.backend_sis_dis_2025_a.entity.Activity;
import com.corhuila.backend_sis_dis_2025_a.entity.SubcategoryActivity;
import com.corhuila.backend_sis_dis_2025_a.repository.ActivityRepository;
import com.corhuila.backend_sis_dis_2025_a.repository.SubcategoryActivityRepository;
import com.corhuila.backend_sis_dis_2025_a.service.IActivityService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements IActivityService {

    private final ActivityRepository repo;
    private final SubcategoryActivityRepository subRepo;

    private ActivityDto toDto(Activity e) {
        return ActivityDto.builder()
                .id(e.getId())
                .name(e.getName())
                .weeklyHours(e.getWeeklyHours())
                .semesterHours(e.getSemesterHours())
                .description(e.getDescription())
                .product(e.getProduct())
                .status(e.getStatus())
                .subcategoryId(e.getSubcategory().getId())
                .build();
    }

    private Activity toEntity(ActivityDto d) {
        SubcategoryActivity sub = subRepo.findById(d.getSubcategoryId())
                .orElseThrow(() -> new RuntimeException("Subcategory not found"));
        return Activity.builder()
                .id(d.getId())
                .name(d.getName())
                .weeklyHours(d.getWeeklyHours())
                .semesterHours(d.getSemesterHours())
                .description(d.getDescription())
                .product(d.getProduct())
                .status(d.getStatus())
                .subcategory(sub)
                .build();
    }

    @Override public ActivityDto create(ActivityDto dto) {
        return toDto(repo.save(toEntity(dto)));
    }
    @Override public ActivityDto update(Long id, ActivityDto dto) {
        Activity e = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity not found"));
        e.setName(dto.getName());
        e.setWeeklyHours(dto.getWeeklyHours());
        e.setSemesterHours(dto.getSemesterHours());
        e.setDescription(dto.getDescription());
        e.setProduct(dto.getProduct());
        e.setStatus(dto.getStatus());
        e.setSubcategory(subRepo.findById(dto.getSubcategoryId())
                .orElseThrow(() -> new RuntimeException("Subcategory not found")));
        return toDto(repo.save(e));
    }
    @Override public void delete(Long id) { repo.deleteById(id); }
    @Override public ActivityDto findById(Long id) {
        return repo.findById(id).map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Activity not found"));
    }
    @Override public List<ActivityDto> findAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}


