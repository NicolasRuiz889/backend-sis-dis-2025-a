package com.corhuila.backend_sis_dis_2025_a.controller;

import com.corhuila.backend_sis_dis_2025_a.dto.request.PersonaRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.PersonaResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.Persona;
import com.corhuila.backend_sis_dis_2025_a.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @PostMapping
    public ResponseEntity<PersonaResponseDTO> createPersona(@RequestBody PersonaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personaService.savePersona(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaResponseDTO> updatePersona(@PathVariable Long id, @RequestBody PersonaRequestDTO dto) {
        return ResponseEntity.ok(personaService.updatePersona(id, dto));
    }

    @GetMapping
    public ResponseEntity<List<PersonaResponseDTO>> getAllPersonas() {
        return ResponseEntity.ok(personaService.getAllPersonas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaResponseDTO> getPersonaById(@PathVariable Long id) {
        return ResponseEntity.ok(personaService.getPersonaById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable Long id) {
        personaService.deletePersona(id);
        return ResponseEntity.noContent().build();
    }

}
