package com.corhuila.backend_sis_dis_2025_a.controller;

import com.corhuila.backend_sis_dis_2025_a.dto.request.PersonRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.PersonResponse;
import com.corhuila.backend_sis_dis_2025_a.service.IPersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final IPersonService service;

    @PostMapping
    public ResponseEntity<PersonResponse> create(@Valid @RequestBody PersonRequest r) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(r));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonResponse> update(@PathVariable Long id, @Valid @RequestBody PersonRequest r) {
        return ResponseEntity.ok(service.update(id, r));
    }

    @GetMapping
    public ResponseEntity<List<PersonResponse>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

