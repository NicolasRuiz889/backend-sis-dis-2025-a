package com.corhuila.backend_sis_dis_2025_a.controller;

import com.corhuila.backend_sis_dis_2025_a.dto.request.ActividadRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.ActividadResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.service.IActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actividades")
public class ActividadController {

    @Autowired
    private IActividadService service;

    @PostMapping
    public ResponseEntity<ActividadResponseDTO> create(@RequestBody ActividadRequestDTO dto) {
        return ResponseEntity.status(201).body(service.saveActividad(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActividadResponseDTO> update(@PathVariable Long id, @RequestBody ActividadRequestDTO dto) {
        return ResponseEntity.ok(service.updateActividad(id, dto));
    }

    @GetMapping
    public ResponseEntity<List<ActividadResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAllActividades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActividadResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getActividadById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteActividad(id);
        return ResponseEntity.noContent().build();
    }
}
