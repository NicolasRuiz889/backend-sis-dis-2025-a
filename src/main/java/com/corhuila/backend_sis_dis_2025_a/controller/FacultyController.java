package com.corhuila.backend_sis_dis_2025_a.controller;

import com.corhuila.backend_sis_dis_2025_a.dto.request.FacultyRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.FacultyResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.corhuila.backend_sis_dis_2025_a.service.IFacultyService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/faculties")
@RequiredArgsConstructor
public class FacultyController {

    private final IFacultyService service;

    @PostMapping
    public ResponseEntity<FacultyResponse> create(@Valid @RequestBody FacultyRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacultyResponse> update(@PathVariable Long id,
                                                  @Valid @RequestBody FacultyRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @GetMapping
    public ResponseEntity<List<FacultyResponse>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacultyResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
