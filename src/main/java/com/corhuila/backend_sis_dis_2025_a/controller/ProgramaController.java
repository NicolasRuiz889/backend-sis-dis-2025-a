package com.corhuila.backend_sis_dis_2025_a.controller;

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
    public ResponseEntity<Programa> createPrograma(@RequestBody Programa programa) {
        Programa savedPrograma = programaService.savePrograma(programa);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPrograma);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Programa> updatePrograma(@PathVariable Long id, @RequestBody Programa programa) {
        Programa updatedPrograma = programaService.updatePrograma(id, programa);
        return ResponseEntity.ok(updatedPrograma);
    }

    @GetMapping
    public ResponseEntity<List<Programa>> getAllProgramas() {
        List<Programa> programas = programaService.getAllProgramas();
        return ResponseEntity.ok(programas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Programa> getProgramaById(@PathVariable Long id) {
        Programa programa = programaService.getProgramaById(id);
        return ResponseEntity.ok(programa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrograma(@PathVariable Long id) {
        programaService.deletePrograma(id);
        return ResponseEntity.noContent().build();
    }

}
