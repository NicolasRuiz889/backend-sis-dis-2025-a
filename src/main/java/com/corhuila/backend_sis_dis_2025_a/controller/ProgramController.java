package com.corhuila.backend_sis_dis_2025_a.controller;

import com.corhuila.backend_sis_dis_2025_a.dto.request.ProgramRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.ProgramResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.corhuila.backend_sis_dis_2025_a.service.IProgramService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/programs")
@RequiredArgsConstructor
public class ProgramController {

    private final IProgramService service;

    @PostMapping
    public ResponseEntity<ProgramResponse> create(@Valid @RequestBody ProgramRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramResponse> update(@PathVariable Long id,
                                                  @Valid @RequestBody ProgramRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @GetMapping
    public ResponseEntity<List<ProgramResponse>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
