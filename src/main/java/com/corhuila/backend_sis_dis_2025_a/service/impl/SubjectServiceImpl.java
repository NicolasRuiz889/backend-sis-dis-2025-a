package com.corhuila.backend_sis_dis_2025_a.service.impl;

import org.springframework.stereotype.Service;
import com.corhuila.backend_sis_dis_2025_a.entity.Program;
import com.corhuila.backend_sis_dis_2025_a.repository.IProgramRepository;

import com.corhuila.backend_sis_dis_2025_a.dto.SubjectDto;
import com.corhuila.backend_sis_dis_2025_a.entity.Subject;
import com.corhuila.backend_sis_dis_2025_a.repository.ISubjectRepository;
import com.corhuila.backend_sis_dis_2025_a.service.ISubjectService;
import java.util.List;

import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements ISubjectService {

    private final ISubjectRepository subjectRepository;
    private final IProgramRepository programRepository;

    private SubjectDto toDto(Subject e) {
        return SubjectDto.builder()
                .id(e.getId())
                .code(e.getCode())
                .name(e.getName())
                .status(e.getStatus())
                .programId(e.getProgram().getId())
                .build();
    }

    private Subject toEntity(SubjectDto d) {
        Program program = programRepository.findById(d.getProgramId())
                .orElseThrow(() -> new RuntimeException("Program not found"));
        return Subject.builder()
                .id(d.getId())
                .code(d.getCode())
                .name(d.getName())
                .status(d.getStatus())
                .program(program)
                .build();
    }

    @Override
    public SubjectDto create(SubjectDto dto) {
        return toDto(subjectRepository.save(toEntity(dto)));
    }

    @Override
    public SubjectDto update(Long id, SubjectDto dto) {
        Subject e = subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found"));
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        e.setProgram(programRepository.findById(dto.getProgramId())
                .orElseThrow(() -> new RuntimeException("Program not found")));
        return toDto(subjectRepository.save(e));
    }

    @Override
    public void delete(Long id) {
        subjectRepository.deleteById(id);
    }
    @Override
    public SubjectDto findById(Long id) {
        return toDto(subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found")));
    }

    @Override
    public List<SubjectDto> findAll() {
        return subjectRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    
}
}
