package com.corhuila.backend_sis_dis_2025_a.controller;

import com.corhuila.backend_sis_dis_2025_a.dto.request.SubcategoriaActividadRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.SubcategoriaActividadResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.service.ISubcategoriaActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subcategorias")
public class SubcategoriaActividadController {

    @Autowired
    private ISubcategoriaActividadService service;

    @PostMapping
    public ResponseEntity<SubcategoriaActividadResponseDTO> create(@RequestBody SubcategoriaActividadRequestDTO dto) {
        return ResponseEntity.status(201).body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubcategoriaActividadResponseDTO> update(@PathVariable Long id, @RequestBody SubcategoriaActividadRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @GetMapping
    public ResponseEntity<List<SubcategoriaActividadResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubcategoriaActividadResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
