package com.corhuila.backend_sis_dis_2025_a.controller;

import com.corhuila.backend_sis_dis_2025_a.dto.request.ProgramaRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.ProgramaResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.Programa;
import com.corhuila.backend_sis_dis_2025_a.service.IProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programas")
public class ProgramaController {

    @Autowired
    private IProgramaService programaService;

    @PostMapping
    public ResponseEntity<ProgramaResponseDTO> createPrograma(@RequestBody ProgramaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(programaService.savePrograma(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramaResponseDTO> updatePrograma(@PathVariable Long id, @RequestBody ProgramaRequestDTO dto) {
        return ResponseEntity.ok(programaService.updatePrograma(id, dto));
    }

    @GetMapping
    public ResponseEntity<List<ProgramaResponseDTO>> getAllProgramas() {
        return ResponseEntity.ok(programaService.getAllProgramas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramaResponseDTO> getProgramaById(@PathVariable Long id) {
        return ResponseEntity.ok(programaService.getProgramaById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrograma(@PathVariable Long id) {
        programaService.deletePrograma(id);
        return ResponseEntity.noContent().build();
    }

}
