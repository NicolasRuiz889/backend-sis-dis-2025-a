// src/main/java/com/corhuila/backend_sis_dis_2025_a/controller/CategoryController.java
package com.corhuila.backend_sis_dis_2025_a.controller;

import com.corhuila.backend_sis_dis_2025_a.dto.CategoryDto;
import com.corhuila.backend_sis_dis_2025_a.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryService service;

    @PostMapping      public CategoryDto create(@RequestBody CategoryDto dto) { return service.create(dto); }
    @GetMapping       public List<CategoryDto> getAll()                   { return service.findAll(); }
    @GetMapping("/{id}") public CategoryDto getById(@PathVariable Long id)  { return service.findById(id); }
    @PutMapping("/{id}") public CategoryDto update(@PathVariable Long id,@RequestBody CategoryDto dto){ return service.update(id,dto); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id)        { service.delete(id); }
}


