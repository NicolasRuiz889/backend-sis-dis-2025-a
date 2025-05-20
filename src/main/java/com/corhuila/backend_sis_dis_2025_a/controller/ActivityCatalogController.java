package com.corhuila.backend_sis_dis_2025_a.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.corhuila.backend_sis_dis_2025_a.dto.ActivityCatalogDto;
import com.corhuila.backend_sis_dis_2025_a.service.IActivityCatalogService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/activitiescatalogs")
@RequiredArgsConstructor
public class ActivityCatalogController {

    private final IActivityCatalogService service;

    @PostMapping      public ActivityCatalogDto create(@RequestBody ActivityCatalogDto dto) { return service.create(dto); }
    @GetMapping       public List<ActivityCatalogDto> getAll()                               { return service.findAll(); }
    @GetMapping("/{id}") public ActivityCatalogDto getById(@PathVariable Long id)            { return service.findById(id); }
    @PutMapping("/{id}") public ActivityCatalogDto update(@PathVariable Long id,@RequestBody ActivityCatalogDto dto){ return service.update(id,dto); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id)                          { service.delete(id); }
    
}
