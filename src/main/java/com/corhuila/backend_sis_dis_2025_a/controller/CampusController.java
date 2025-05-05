package com.corhuila.backend_sis_dis_2025_a.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corhuila.backend_sis_dis_2025_a.dto.CampusDto;
import com.corhuila.backend_sis_dis_2025_a.service.ICampusService;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/campuses")
@RequiredArgsConstructor
public class CampusController {

     private final ICampusService service;

    @PostMapping      public CampusDto create(@RequestBody CampusDto dto) { return service.create(dto); }
    @GetMapping       public List<CampusDto> getAll()                   { return service.findAll(); }
    @GetMapping("/{id}") public CampusDto getById(@PathVariable Long id)  { return service.findById(id); }
    @PutMapping("/{id}") public CampusDto update(@PathVariable Long id,@RequestBody CampusDto dto){ return service.update(id,dto); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id)        { service.delete(id); }
    
}
