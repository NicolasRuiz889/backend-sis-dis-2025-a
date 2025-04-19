// src/main/java/com/corhuila/backend_sis_dis_2025_a/controller/AgendaController.java
package com.corhuila.backend_sis_dis_2025_a.controller;

import com.corhuila.backend_sis_dis_2025_a.dto.AgendaDto;
import com.corhuila.backend_sis_dis_2025_a.service.IAgendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/agendas")
@RequiredArgsConstructor
public class AgendaController {

    private final IAgendaService service;

    @PostMapping      public AgendaDto create(@RequestBody AgendaDto dto) { return service.create(dto); }
    @GetMapping       public List<AgendaDto> getAll()                  { return service.findAll(); }
    @GetMapping("/{id}") public AgendaDto getById(@PathVariable Long id){ return service.findById(id); }
    @PutMapping("/{id}") public AgendaDto update(@PathVariable Long id,@RequestBody AgendaDto dto){ return service.update(id,dto); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id)   { service.delete(id); }
}

