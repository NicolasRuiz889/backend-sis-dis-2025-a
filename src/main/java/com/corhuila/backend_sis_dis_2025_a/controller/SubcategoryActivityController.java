package com.corhuila.backend_sis_dis_2025_a.controller;

import com.corhuila.backend_sis_dis_2025_a.dto.SubcategoryActivityDto;
import com.corhuila.backend_sis_dis_2025_a.service.ISubcategoryActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/subcategories")
@RequiredArgsConstructor
public class SubcategoryActivityController {

    private final ISubcategoryActivityService service;

    @PostMapping      public SubcategoryActivityDto create(@RequestBody SubcategoryActivityDto dto) { return service.create(dto); }
    @GetMapping       public List<SubcategoryActivityDto> getAll()                               { return service.findAll(); }
    @GetMapping("/{id}") public SubcategoryActivityDto getById(@PathVariable Long id)            { return service.findById(id); }
    @PutMapping("/{id}") public SubcategoryActivityDto update(@PathVariable Long id,@RequestBody SubcategoryActivityDto dto){ return service.update(id,dto); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id)                          { service.delete(id); }
}
