package com.corhuila.backend_sis_dis_2025_a.controller;

import org.springframework.web.bind.annotation.*;

import com.corhuila.backend_sis_dis_2025_a.dto.FacultyDto;
import com.corhuila.backend_sis_dis_2025_a.service.IFacultyService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/faculties")
@RequiredArgsConstructor
public class FacultyController {

    private final IFacultyService service;

    @PostMapping      public FacultyDto create(@RequestBody FacultyDto dto) { return service.create(dto); }
    @GetMapping       public List<FacultyDto> getAll()                  { return service.findAll(); }
    @GetMapping("/{id}") public FacultyDto getById(@PathVariable Long id){ return service.findById(id); }
    @PutMapping("/{id}") public FacultyDto update(@PathVariable Long id,@RequestBody FacultyDto dto){ return service.update(id,dto); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id)   { service.delete(id); }
    
}
