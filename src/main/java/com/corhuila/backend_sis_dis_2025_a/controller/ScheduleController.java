package com.corhuila.backend_sis_dis_2025_a.controller;

import com.corhuila.backend_sis_dis_2025_a.dto.ScheduleDtp;
import com.corhuila.backend_sis_dis_2025_a.service.IScheduleServicie;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class ScheduleController {
    
    private final IScheduleServicie service;

    @PostMapping
    public ScheduleDto create(@RequestBody ScheduleDto) {
        return service.create(dto);
    }

    @GetMapping
    public List<ScheduleDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ScheduleDto getById
}
