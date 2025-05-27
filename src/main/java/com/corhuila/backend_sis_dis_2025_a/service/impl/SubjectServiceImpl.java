package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.request.SubjectRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.SubjectResponse;
import org.springframework.stereotype.Service;

import com.corhuila.backend_sis_dis_2025_a.entity.Program;
import com.corhuila.backend_sis_dis_2025_a.entity.Subject;
import com.corhuila.backend_sis_dis_2025_a.repository.IProgramRepository;
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

    private Subject toEntity(SubjectRequest request) {
        Program program = programRepository.findById(request.getProgramId())
                .orElseThrow(() -> new RuntimeException("Program not found"));

        return Subject.builder()
                .code(request.getCode())
                .name(request.getName())
                .credits(request.getCredits())
                .description(request.getDescription())
                .status(request.getStatus())
                .program(program)
                .build();
    }

    private SubjectResponse toResponse(Subject subject) {
        return SubjectResponse.builder()
                .id(subject.getId())
                .code(subject.getCode())
                .name(subject.getName())
                .credits(subject.getCredits())
                .description(subject.getDescription())
                .status(subject.getStatus())
                .programId(subject.getProgram().getId())
                .programName(subject.getProgram().getName())
                .build();
    }

    @Override
    public SubjectResponse create(SubjectRequest request) {
        return toResponse(subjectRepository.save(toEntity(request)));
    }

    @Override
    public SubjectResponse update(Long id, SubjectRequest request) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        subject.setCode(request.getCode());
        subject.setName(request.getName());
        subject.setCredits(request.getCredits());
        subject.setDescription(request.getDescription());
        subject.setStatus(request.getStatus());
        subject.setProgram(programRepository.findById(request.getProgramId())
                .orElseThrow(() -> new RuntimeException("Program not found")));

        return toResponse(subjectRepository.save(subject));
    }

    @Override
    public void delete(Long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public SubjectResponse findById(Long id) {
        return subjectRepository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Subject not found"));
    }

    @Override
    public List<SubjectResponse> findAll() {
        return subjectRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
