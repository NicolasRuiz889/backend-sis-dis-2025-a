package com.corhuila.backend_sis_dis_2025_a.controller;

import com.corhuila.backend_sis_dis_2025_a.entity.Grupo;
import com.corhuila.backend_sis_dis_2025_a.service.IGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    private IGrupoService grupoService;

    @PostMapping
    public ResponseEntity<Grupo> createGrupo(@RequestBody Grupo grupo) {
        Grupo savedGrupo = grupoService.saveGrupo(grupo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGrupo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grupo> updateGrupo(@PathVariable Long id, @RequestBody Grupo grupo) {
        Grupo updatedGrupo = grupoService.updateGrupo(id, grupo);
        return ResponseEntity.ok(updatedGrupo);
    }

    @GetMapping
    public ResponseEntity<List<Grupo>> getAllGrupos() {
        List<Grupo> grupos = grupoService.getAllGrupos();
        return ResponseEntity.ok(grupos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grupo> getGrupoById(@PathVariable Long id) {
        Grupo grupo = grupoService.getGrupoById(id);
        return ResponseEntity.ok(grupo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrupo(@PathVariable Long id) {
        grupoService.deleteGrupo(id);
        return ResponseEntity.noContent().build();
    }

}
