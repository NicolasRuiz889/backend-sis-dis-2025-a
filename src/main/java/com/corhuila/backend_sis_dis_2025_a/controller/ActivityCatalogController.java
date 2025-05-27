package com.corhuila.backend_sis_dis_2025_a.controller;

import com.corhuila.backend_sis_dis_2025_a.dto.request.ActivityCatalogRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.ActivityCatalogResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.corhuila.backend_sis_dis_2025_a.service.IActivityCatalogService;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/activitiescatalogs")
@RequiredArgsConstructor
public class ActivityCatalogController {

    private final IActivityCatalogService service;

    @PostMapping
    public ResponseEntity<ActivityCatalogResponse> create(@Valid @RequestBody ActivityCatalogRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActivityCatalogResponse> update(@PathVariable Long id,
                                                          @Valid @RequestBody ActivityCatalogRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @GetMapping
    public ResponseEntity<List<ActivityCatalogResponse>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityCatalogResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
