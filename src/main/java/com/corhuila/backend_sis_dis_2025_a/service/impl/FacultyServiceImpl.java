package com.corhuila.backend_sis_dis_2025_a.service.impl;

import java.util.stream.Collectors;
import java.util.List;
import org.springframework.stereotype.Service;

import com.corhuila.backend_sis_dis_2025_a.dto.FacultyDto;
import com.corhuila.backend_sis_dis_2025_a.entity.Campus;
import com.corhuila.backend_sis_dis_2025_a.entity.Faculty;
import com.corhuila.backend_sis_dis_2025_a.repository.ICampusRepository;
import com.corhuila.backend_sis_dis_2025_a.repository.IFacultyRepository;
import com.corhuila.backend_sis_dis_2025_a.service.IFacultyService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements IFacultyService {
    
    private final IFacultyRepository repo;
    private final ICampusRepository camRepo;

    private FacultyDto toDto(Faculty e) {
        return FacultyDto.builder()
                .id(e.getId())
                .name(e.getName())
                .description(e.getDescription())
                .status(e.getStatus())
                .campusId(e.getCampus().getId())
                .build();
    }

    private Faculty toEntity(FacultyDto d) {
        Campus cam = camRepo.findById(d.getCampusId())
                .orElseThrow(() -> new RuntimeException("Campus not found"));
        return Faculty.builder()
                .id(d.getId())
                .name(d.getName())
                .description(d.getDescription())
                .status(d.getStatus())
                .campus(cam)
                .build();
    }

    @Override public FacultyDto create(FacultyDto dto) {
        return toDto(repo.save(toEntity(dto)));
    }
    @Override public FacultyDto update(Long id, FacultyDto dto) {
        Faculty e = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Faculty not found"));
        e.setName(dto.getName());
        e.setDescription(dto.getDescription());
        e.setStatus(dto.getStatus());
        e.setCampus(camRepo.findById(dto.getCampusId())
                .orElseThrow(() -> new RuntimeException("Faculty not found")));
        return toDto(repo.save(e));
    }
    @Override public void delete(Long id) { repo.deleteById(id); }
    @Override public FacultyDto findById(Long id) {
        return repo.findById(id).map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Faculty not found"));
    }
    @Override public List<FacultyDto> findAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
