package com.corhuila.backend_sis_dis_2025_a.controller;

import com.corhuila.backend_sis_dis_2025_a.dto.ScheduleDto;
import com.corhuila.backend_sis_dis_2025_a.service.IScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class ScheduleController {
    
    private final IScheduleService service;

    @PostMapping
    public ScheduleDto create(@RequestBody ScheduleDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<ScheduleDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ScheduleDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public ScheduleDto update(@PathVariable Long id, @RequestBody ScheduleDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
