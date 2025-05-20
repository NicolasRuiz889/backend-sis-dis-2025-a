package com.corhuila.backend_sis_dis_2025_a.controller;

import com.corhuila.backend_sis_dis_2025_a.dto.request.RolesRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.RolesResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private IRolesService rolesService;

    @PostMapping
    public ResponseEntity<RolesResponseDTO> create(@RequestBody RolesRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rolesService.saveRoles(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolesResponseDTO> update(@PathVariable Long id, @RequestBody RolesRequestDTO dto) {
        return ResponseEntity.ok(rolesService.updateRoles(id, dto));
    }

    @GetMapping
    public ResponseEntity<List<RolesResponseDTO>> getAll() {
        return ResponseEntity.ok(rolesService.getAllRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolesResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(rolesService.getRolesById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        rolesService.deleteRoles(id);
        return ResponseEntity.noContent().build();
    }
}
