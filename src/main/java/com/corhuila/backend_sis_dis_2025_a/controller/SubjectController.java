package com.corhuila.backend_sis_dis_2025_a.controller;

import com.corhuila.backend_sis_dis_2025_a.dto.SubjectDto;
import com.corhuila.backend_sis_dis_2025_a.service.ISubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
@RequiredArgsConstructor
public class SubjectController {
    
    private final ISubjectService service;

    @PostMapping
    public SubjectDto create(@RequestBody SubjectDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<SubjectDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public SubjectDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public SubjectDto update(@PathVariable Long id, @RequestBody SubjectDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
