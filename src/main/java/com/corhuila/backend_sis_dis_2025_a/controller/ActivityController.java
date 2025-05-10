// src/main/java/com/corhuila/backend_sis_dis_2025_a/controller/ActivityController.java
package com.corhuila.backend_sis_dis_2025_a.controller;

import com.corhuila.backend_sis_dis_2025_a.dto.ActivityDto;
import com.corhuila.backend_sis_dis_2025_a.service.IActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final IActivityService service;

    @PostMapping      public ActivityDto create(@RequestBody ActivityDto dto) { return service.create(dto); }
    @GetMapping       public List<ActivityDto> getAll()                   { return service.findAll(); }
    @GetMapping("/{id}") public ActivityDto getById(@PathVariable Long id)  { return service.findById(id); }
    @PutMapping("/{id}") public ActivityDto update(@PathVariable Long id,@RequestBody ActivityDto dto){ return service.update(id,dto); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id)        { service.delete(id); }
}

