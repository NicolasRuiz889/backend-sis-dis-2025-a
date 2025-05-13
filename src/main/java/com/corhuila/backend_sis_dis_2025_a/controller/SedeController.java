package com.corhuila.backend_sis_dis_2025_a.controller;

import com.corhuila.backend_sis_dis_2025_a.entity.Sede;
import com.corhuila.backend_sis_dis_2025_a.service.ISedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sedes")
public class SedeController {

    @Autowired
    private ISedeService sedeService;

    @PostMapping
    public ResponseEntity<Sede> createSede(@RequestBody Sede sede) {
        Sede savedSede = sedeService.saveSede(sede);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSede);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sede> updateSede(@PathVariable Long id, @RequestBody Sede sede) {
        Sede updatedSede = sedeService.updateSede(id, sede);
        return ResponseEntity.ok(updatedSede);
    }

    @GetMapping
    public ResponseEntity<List<Sede>> getAllSedes() {
        List<Sede> sedes = sedeService.getAllSedes();
        return ResponseEntity.ok(sedes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sede> getSedeById(@PathVariable Long id) {
        Sede sede = sedeService.getSedeById(id);
        return ResponseEntity.ok(sede);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSede(@PathVariable Long id) {
        sedeService.deleteSede(id);
        return ResponseEntity.noContent().build();
    }

}
