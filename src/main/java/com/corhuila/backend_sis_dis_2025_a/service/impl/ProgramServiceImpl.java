package com.corhuila.backend_sis_dis_2025_a.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.corhuila.backend_sis_dis_2025_a.dto.ProgramDto;
import com.corhuila.backend_sis_dis_2025_a.entity.Faculty;
import com.corhuila.backend_sis_dis_2025_a.entity.Program;
import com.corhuila.backend_sis_dis_2025_a.repository.IFacultyRepository;
import com.corhuila.backend_sis_dis_2025_a.repository.IProgramRepository;
import com.corhuila.backend_sis_dis_2025_a.service.IProgramService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProgramServiceImpl implements IProgramService {

    private final IProgramRepository repo;
    private final IFacultyRepository facRepo;

    private ProgramDto toDto(Program e) {
        return ProgramDto.builder()
                .id(e.getId())
                .code(e.getCode())
                .name(e.getName())
                .modality(e.getModality())
                .schedule(e.getSchedule())
                .duration(e.getDuration())
                .degreeAwarded(e.getDegreeAwarded())
                .status(e.getStatus())
                .facultyId(e.getFaculty().getId())
                .build();
    }

    private Program toEntity(ProgramDto d) {
        Faculty fac = facRepo.findById(d.getFacultyId())
                .orElseThrow(() -> new RuntimeException("Faculty not found"));
        return Program.builder()
                .id(d.getId())
                .code(d.getCode())
                .name(d.getName())
                .modality(d.getModality())
                .schedule(d.getSchedule())
                .duration(d.getDuration())
                .degreeAwarded(d.getDegreeAwarded())
                .status(d.getStatus())
                .faculty(fac)
                .build();
    }

    @Override public ProgramDto create(ProgramDto dto) {
        return toDto(repo.save(toEntity(dto)));
    }
    @Override public ProgramDto update(Long id, ProgramDto dto) {
        Program e = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Program not found"));
        e.setCode(dto.getCode());        
        e.setName(dto.getName());
        e.setModality(dto.getModality());
        e.setSchedule(dto.getSchedule());
        e.setDuration(dto.getDuration());
        e.setDegreeAwarded(dto.getDegreeAwarded());
        e.setStatus(dto.getStatus());
        e.setFaculty(facRepo.findById(dto.getFacultyId())
                .orElseThrow(() -> new RuntimeException("Program not found")));
        return toDto(repo.save(e));
    }
    @Override public void delete(Long id) { repo.deleteById(id); }
    @Override public ProgramDto findById(Long id) {
        return repo.findById(id).map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Program not found"));
    }
    @Override public List<ProgramDto> findAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
    
}
