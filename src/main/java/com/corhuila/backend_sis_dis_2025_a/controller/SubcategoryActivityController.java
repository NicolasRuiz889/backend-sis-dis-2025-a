package com.corhuila.backend_sis_dis_2025_a.controller;

import com.corhuila.backend_sis_dis_2025_a.dto.request.SubcategoryActivityRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.SubcategoryActivityResponse;
import com.corhuila.backend_sis_dis_2025_a.service.ISubcategoryActivityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/subcategories")
@RequiredArgsConstructor
public class SubcategoryActivityController {

    private final ISubcategoryActivityService service;

    @PostMapping
    public ResponseEntity<SubcategoryActivityResponse> create(@Valid @RequestBody SubcategoryActivityRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubcategoryActivityResponse> update(@PathVariable Long id,
                                                              @Valid @RequestBody SubcategoryActivityRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @GetMapping
    public ResponseEntity<List<SubcategoryActivityResponse>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubcategoryActivityResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
