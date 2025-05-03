package com.corhuila.backend_sis_dis_2025_a.controller;

import com.corhuila.backend_sis_dis_2025_a.dto.GroupDto;
import com.corhuila.backend_sis_dis_2025_a.service.IGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupController {

    private final IGroupService service;

    @PostMapping
    public GroupDto create(@RequestBody GroupDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<GroupDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public GroupDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public GroupDto update(@PathVariable Long id, @RequestBody GroupDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

