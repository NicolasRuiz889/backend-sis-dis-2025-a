package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.request.ActivityRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.request.ProductRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.ActivityResponse;
import com.corhuila.backend_sis_dis_2025_a.dto.response.ProductResponse;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements IActivityService {

    private final ActivityRepository repo;
    private final SubcategoryActivityRepository subRepo;
    private final ActivityCatalogRepository activityCatalogRepo;

    private Activity toEntity(ActivityRequest request) {
        ActivityCatalog catalog = activityCatalogRepo.findById(request.getActivityCatalogId())
                .orElseThrow(() -> new RuntimeException("Activity Catalog not found"));

        SubcategoryActivity subcategory = subRepo.findById(request.getSubcategoryId())
                .orElseThrow(() -> new RuntimeException("Subcategory not found"));

        Activity activity = Activity.builder()
                .weeklyHours(request.getWeeklyHours())
                .semesterHours(request.getWeeklyHours() * 16)
                .description(request.getDescription())
                .status(Optional.ofNullable(request.getStatus()).orElse(true))
                .activityCatalog(catalog)
                .subcategory(subcategory)
                .build();

        if (request.getProducts() != null) {
            List<Product> products = request.getProducts().stream()
                    .map(p -> Product.builder()
                            .id(p.getId())
                            .name(p.getName())
                            .activity(activity)
                            .build())
                    .collect(Collectors.toList());
            activity.setProducts(products);
        }

        return activity;
    }

    private ActivityResponse toResponse(Activity activity) {
        return ActivityResponse.builder()
                .id(activity.getId())
                .description(activity.getDescription())
                .weeklyHours(activity.getWeeklyHours())
                .semesterHours(activity.getSemesterHours())
                .status(activity.getStatus())
                .activityCatalogId(activity.getActivityCatalog().getId())
                .activityCatalogName(activity.getActivityCatalog().getName())
                .subcategoryId(activity.getSubcategory().getId())
                .subcategoryName(activity.getSubcategory().getName())
                .categoryName(activity.getSubcategory().getCategory().getName())
                .products(activity.getProducts().stream()
                        .map(p -> ProductResponse.builder()
                                .id(p.getId())
                                .name(p.getName())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public ActivityResponse create(ActivityRequest request) {
        Activity entity = toEntity(request);
        return toResponse(repo.save(entity));
    }

    @Override
    public ActivityResponse update(Long id, ActivityRequest request) {
        Activity existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity not found"));

        existing.setWeeklyHours(request.getWeeklyHours());
        existing.setSemesterHours(request.getWeeklyHours() * 16);
        existing.setDescription(request.getDescription());
        existing.setStatus(Optional.ofNullable(request.getStatus()).orElse(true));
        existing.setActivityCatalog(activityCatalogRepo.findById(request.getActivityCatalogId())
                .orElseThrow(() -> new RuntimeException("Activity Catalog not found")));
        existing.setSubcategory(subRepo.findById(request.getSubcategoryId())
                .orElseThrow(() -> new RuntimeException("Subcategory not found")));

        existing.getProducts().clear();
        if (request.getProducts() != null) {
            for (ProductRequest p : request.getProducts()) {
                Product product = Product.builder()
                        .id(p.getId())
                        .name(p.getName())
                        .activity(existing)
                        .build();
                existing.getProducts().add(product);
            }
        }

        return toResponse(repo.save(existing));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public ActivityResponse findById(Long id) {
        return repo.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Activity not found"));
    }

    @Override
    public List<ActivityResponse> findAll() {
        return repo.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ActivityResponse> findByProfesorId(Long profesorId) {
        return repo.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
