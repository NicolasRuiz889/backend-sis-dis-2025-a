package com.corhuila.backend_sis_dis_2025_a.controller;

import com.corhuila.backend_sis_dis_2025_a.dto.request.ClassOrientationRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.ClassOrientationResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.corhuila.backend_sis_dis_2025_a.service.IClassOrientationService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/class-orientations")
@RequiredArgsConstructor
public class ClassOrientationController {

    private final IClassOrientationService service;

    @PostMapping
    public ResponseEntity<ClassOrientationResponse> create(@Valid @RequestBody ClassOrientationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassOrientationResponse> update(@PathVariable Long id,
                                                           @Valid @RequestBody ClassOrientationRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @GetMapping
    public ResponseEntity<List<ClassOrientationResponse>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassOrientationResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
