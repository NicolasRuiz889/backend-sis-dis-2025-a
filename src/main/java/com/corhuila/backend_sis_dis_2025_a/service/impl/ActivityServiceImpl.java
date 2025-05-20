package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.ActivityDto;
import com.corhuila.backend_sis_dis_2025_a.dto.ProductDto;
import com.corhuila.backend_sis_dis_2025_a.entity.Activity;
import com.corhuila.backend_sis_dis_2025_a.entity.ActivityCatalog;
import com.corhuila.backend_sis_dis_2025_a.entity.Product;
import com.corhuila.backend_sis_dis_2025_a.entity.SubcategoryActivity;
import com.corhuila.backend_sis_dis_2025_a.repository.ActivityCatalogRepository;
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
    private final ActivityCatalogRepository activityCatalogRepo;

    private ActivityDto toDto(Activity e) {

        List<ProductDto> productDtos = e.getProducts().stream()
                .map(p -> ProductDto.builder()
                        .id(p.getId())
                        .name(p.getName())
                        .build())
                .collect(Collectors.toList());

        return ActivityDto.builder()
                .id(e.getId())
                .activityCatalogId(e.getActivityCatalog().getId())
                .activityCatalogName(e.getActivityCatalog().getName())
                .weeklyHours(e.getWeeklyHours())
                .semesterHours(e.getSemesterHours())
                .description(e.getDescription())
                .product(productDtos)
                .status(e.getStatus())
                .subcategoryId(e.getSubcategory().getId())
                .subcategoryName(e.getSubcategory().getName())
                .build();
    }

    private Activity toEntity(ActivityDto d) {
        SubcategoryActivity sub = subRepo.findById(d.getSubcategoryId())
                .orElseThrow(() -> new RuntimeException("Subcategory not found"));

        ActivityCatalog activityCatalog = activityCatalogRepo.findById(d.getActivityCatalogId())
                .orElseThrow(() -> new RuntimeException("Activity Catalog not found"));
        Activity activity = Activity.builder()
                .id(d.getId())

                .weeklyHours(d.getWeeklyHours())
                .semesterHours(d.getWeeklyHours() * 16) // Calculo de horas semestrales

                .description(d.getDescription())
                .status(d.getStatus())
                .subcategory(sub)
                .activityCatalog(activityCatalog)
                .build();

        // Asignar productos con relación inversa
        if (d.getProduct() != null) {
            List<Product> products = d.getProduct().stream()
                    .map(p -> Product.builder()
                            .id(p.getId()) // Puede ser null si es nuevo
                            .name(p.getName())
                            .activity(activity) // Relación inversa
                            .build())
                    .collect(Collectors.toList());
            activity.setProducts(products);
        }

        return activity;
    }

    @Override
    public ActivityDto create(ActivityDto dto) {
        return toDto(repo.save(toEntity(dto)));
    }

    @Override
    public ActivityDto update(Long id, ActivityDto dto) {
        Activity e = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity not found"));
        e.setActivityCatalog(activityCatalogRepo.findById(dto.getActivityCatalogId())
                .orElseThrow(() -> new RuntimeException("Activity Catalog not found")));
        e.setWeeklyHours(dto.getWeeklyHours());
        e.setSemesterHours(dto.getSemesterHours());
        e.setDescription(dto.getDescription());
        e.setStatus(dto.getStatus());
        e.setSubcategory(subRepo.findById(dto.getSubcategoryId())
                .orElseThrow(() -> new RuntimeException("Subcategory not found")));

        if (dto.getProduct() != null) {
            List<Product> products = dto.getProduct().stream()
                    .map(p -> Product.builder()
                            .id(p.getId())
                            .name(p.getName())
                            .activity(e)
                            .build())
                    .collect(Collectors.toList());
            e.setProducts(products);
        }
        return toDto(repo.save(e));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public ActivityDto findById(Long id) {
        return repo.findById(id).map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Activity not found"));

    }

    @Override
    public List<ActivityDto> findAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
