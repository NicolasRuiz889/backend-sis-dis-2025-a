package com.corhuila.backend_sis_dis_2025_a.controller;

import com.corhuila.backend_sis_dis_2025_a.dto.request.SedeRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.SedeResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.Sede;
import com.corhuila.backend_sis_dis_2025_a.service.ISedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sedes")
public class SedeController {

    @Autowired
    private ISedeService sedeService;

    @PostMapping
    public ResponseEntity<SedeResponseDTO> createSede(@RequestBody SedeRequestDTO sedeDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(sedeService.saveSede(sedeDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SedeResponseDTO> updateSede(@PathVariable Long id, @RequestBody SedeRequestDTO sedeDTO) {
        return ResponseEntity
                .ok(sedeService.updateSede(id, sedeDTO));
    }

    @GetMapping
    public ResponseEntity<List<SedeResponseDTO>> getAllSedes() {
        return ResponseEntity.ok(sedeService.getAllSedes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SedeResponseDTO> getSedeById(@PathVariable Long id) {
        return ResponseEntity.ok(sedeService.getSedeById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSede(@PathVariable Long id) {
        sedeService.deleteSede(id);
        return ResponseEntity.noContent().build();
    }

}
