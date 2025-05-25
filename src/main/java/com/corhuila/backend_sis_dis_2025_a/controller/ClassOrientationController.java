package com.corhuila.backend_sis_dis_2025_a.controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.corhuila.backend_sis_dis_2025_a.dto.ClassOrientationDto;
import com.corhuila.backend_sis_dis_2025_a.service.IClassOrientationService;

import lombok.RequiredArgsConstructor;



@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/class-orientations")
@RequiredArgsConstructor
public class ClassOrientationController {

    private final IClassOrientationService service;

    @PostMapping
    public ClassOrientationDto create(@RequestBody ClassOrientationDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<ClassOrientationDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ClassOrientationDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public ClassOrientationDto update(@PathVariable Long id, @RequestBody ClassOrientationDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }


    
}
