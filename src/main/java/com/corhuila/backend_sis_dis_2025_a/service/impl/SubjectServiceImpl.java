package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.SubjectDto;
import com.corhuila.backend_sis_dis_2025_a.entity.Program;
import com.corhuila.backend_sis_dis_2025_a.entity.Subject;
import com.corhuila.backend_sis_dis_2025_a.repository.ProgramRepository;
import com.corhuila.backend_sis_dis_2025_a.repository.SubjectRepository;
import com.corhuila.backend_sis_dis_2025_a.service.ISubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

@Service
@RequiredArgsConstructor

public class SubjectServiceImpl implements ISubjectService {
    
    private final SubjectRepository repo;
    private final ProgramRepository programRepo;

    private SubjectDto toDto(Subject e) {
        return SubjectDto.builder()
        .id(e.getId())
        .name(e.getName())
        .weeklyHours(e.getWeeklyHours())
        .semesterHours(e.getSemesterHours())
        .programaId(e.getProgram().getId())
        .build();
    }

    private Subject toEntity(SubjectDto d) {
        Program program = programRepo.findById(d.getProgramId())
        .orElseThrow(() -> new RuntimeException("Program not found"));
        return Subject.builder()
        .id(d.getId())
        .name(d.getName())
        .weeklyHours(d.getWeeklyHours())
        .semesterHours(d.getSemesterHours())
        .program(program)
        .build();
    }
 
    @Override
    public SubjectDto create(SubjectDto dto) {
        return toDto(repo.save(toEntity(dto)))
    }

    @Override public SubjectDto update(Long id, SubjectDto dto) {
        Subject subject = repo.findById(id).orElseThrow(() -> new RuntimeException()
    }
}
