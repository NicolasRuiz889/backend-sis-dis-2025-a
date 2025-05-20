package com.corhuila.backend_sis_dis_2025_a.controller;

import com.corhuila.backend_sis_dis_2025_a.dto.request.AsignaturaRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.AsignaturaResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.Asignatura;
import com.corhuila.backend_sis_dis_2025_a.service.IAsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {

    @Autowired
    private IAsignaturaService asignaturaService;

    @PostMapping
    public ResponseEntity<AsignaturaResponseDTO> createAsignatura(@RequestBody AsignaturaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(asignaturaService.saveAsignatura(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsignaturaResponseDTO> updateAsignatura(@PathVariable Long id, @RequestBody AsignaturaRequestDTO dto) {
        return ResponseEntity.ok(asignaturaService.updateAsignatura(id, dto));
    }

    @GetMapping
    public ResponseEntity<List<AsignaturaResponseDTO>> getAllAsignaturas() {
        return ResponseEntity.ok(asignaturaService.getAllAsignaturas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignaturaResponseDTO> getAsignaturaById(@PathVariable Long id) {
        return ResponseEntity.ok(asignaturaService.getAsignaturaById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsignatura(@PathVariable Long id) {
        asignaturaService.deleteAsignatura(id);
        return ResponseEntity.noContent().build();
    }
}
