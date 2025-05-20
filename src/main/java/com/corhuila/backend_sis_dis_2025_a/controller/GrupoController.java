package com.corhuila.backend_sis_dis_2025_a.controller;

import com.corhuila.backend_sis_dis_2025_a.dto.request.GrupoRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.GrupoResponseDTO;
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
    public ResponseEntity<GrupoResponseDTO> createGrupo(@RequestBody GrupoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(grupoService.saveGrupo(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GrupoResponseDTO> updateGrupo(@PathVariable Long id, @RequestBody GrupoRequestDTO dto) {
        return ResponseEntity.ok(grupoService.updateGrupo(id, dto));
    }

    @GetMapping
    public ResponseEntity<List<GrupoResponseDTO>> getAllGrupos() {
        return ResponseEntity.ok(grupoService.getAllGrupos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrupoResponseDTO> getGrupoById(@PathVariable Long id) {
        return ResponseEntity.ok(grupoService.getGrupoById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrupo(@PathVariable Long id) {
        grupoService.deleteGrupo(id);
        return ResponseEntity.noContent().build();
    }

}
