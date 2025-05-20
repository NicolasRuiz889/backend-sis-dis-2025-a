package com.corhuila.backend_sis_dis_2025_a.controller;

import com.corhuila.backend_sis_dis_2025_a.dto.request.TipoVinculacionRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.TipoVinculacionResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.service.ITipoVinculacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-vinculaciones")
public class TipoVinculacionController {

    @Autowired
    private ITipoVinculacionService service;

    @PostMapping
    public ResponseEntity<TipoVinculacionResponseDTO> create(@RequestBody TipoVinculacionRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveTipoVinculacion(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoVinculacionResponseDTO> update(@PathVariable Long id, @RequestBody TipoVinculacionRequestDTO dto) {
        return ResponseEntity.ok(service.updateTipoVinculacion(id, dto));
    }

    @GetMapping
    public ResponseEntity<List<TipoVinculacionResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAllTipoVinculaciones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoVinculacionResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getTipoVinculacionById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteTipoVinculacion(id);
        return ResponseEntity.noContent().build();
    }
}
