package com.corhuila.backend_sis_dis_2025_a.controller;

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
    public ResponseEntity<Facultad> createFacultad(@RequestBody Facultad facultad) {
        Facultad savedFacultad = facultadService.saveFacultad(facultad);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFacultad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Facultad> updateFacultad(@PathVariable Long id, @RequestBody Facultad facultad) {
        Facultad updatedFacultad = facultadService.updateFacultad(id, facultad);
        return ResponseEntity.ok(updatedFacultad);
    }

    @GetMapping
    public ResponseEntity<List<Facultad>> getAllFacultades() {
        List<Facultad> facultades = facultadService.getAllFacultades();
        return ResponseEntity.ok(facultades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facultad> getFacultadById(@PathVariable Long id) {
        Facultad facultad = facultadService.getFacultadById(id);
        return ResponseEntity.ok(facultad);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacultad(@PathVariable Long id) {
        facultadService.deleteFacultad(id);
        return ResponseEntity.noContent().build();
    }

}
