package com.corhuila.backend_sis_dis_2025_a.controller;

import com.corhuila.backend_sis_dis_2025_a.dto.request.FacultadRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.FacultadResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.Facultad;
import com.corhuila.backend_sis_dis_2025_a.service.IFacultadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facultades")
public class FacultadController {

    @Autowired
    private IFacultadService facultadService;

    @PostMapping
    public ResponseEntity<FacultadResponseDTO> createFacultad(@RequestBody FacultadRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(facultadService.saveFacultad(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacultadResponseDTO> updateFacultad(@PathVariable Long id, @RequestBody FacultadRequestDTO dto) {
        return ResponseEntity.ok(facultadService.updateFacultad(id, dto));
    }

    @GetMapping
    public ResponseEntity<List<FacultadResponseDTO>> getAllFacultades() {
        return ResponseEntity.ok(facultadService.getAllFacultades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacultadResponseDTO> getFacultadById(@PathVariable Long id) {
        return ResponseEntity.ok(facultadService.getFacultadById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacultad(@PathVariable Long id) {
        facultadService.deleteFacultad(id);
        return ResponseEntity.noContent().build();
    }

}
