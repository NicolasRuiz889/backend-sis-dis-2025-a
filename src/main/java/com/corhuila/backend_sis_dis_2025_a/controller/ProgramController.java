package com.corhuila.backend_sis_dis_2025_a.controller;

import org.springframework.web.bind.annotation.*;

import com.corhuila.backend_sis_dis_2025_a.dto.ProgramDto;
import com.corhuila.backend_sis_dis_2025_a.service.IProgramService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/programs")
@RequiredArgsConstructor
public class ProgramController {

    private final IProgramService service;

    @PostMapping      public ProgramDto create(@RequestBody ProgramDto dto) { return service.create(dto); }
    @GetMapping       public List<ProgramDto> getAll()                  { return service.findAll(); }
    @GetMapping("/{id}") public ProgramDto getById(@PathVariable Long id){ return service.findById(id); }
    @PutMapping("/{id}") public ProgramDto update(@PathVariable Long id,@RequestBody ProgramDto dto){ return service.update(id,dto); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id)   { service.delete(id); }
    
}
