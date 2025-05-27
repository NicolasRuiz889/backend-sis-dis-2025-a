package com.corhuila.backend_sis_dis_2025_a.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.corhuila.backend_sis_dis_2025_a.dto.request.ProgramRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.ProgramResponse;
import org.springframework.stereotype.Service;
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
    private final IFacultyRepository facultyRepo;

    private Program toEntity(ProgramRequest request) {
        Faculty faculty = facultyRepo.findById(request.getFacultyId())
                .orElseThrow(() -> new RuntimeException("Faculty not found"));

        return Program.builder()
                .code(request.getCode())
                .name(request.getName())
                .modality(request.getModality())
                .schedule(request.getSchedule())
                .duration(request.getDuration())
                .degreeAwarded(request.getDegreeAwarded())
                .status(request.getStatus())
                .faculty(faculty)
                .build();
    }

    private ProgramResponse toResponse(Program program) {
        return ProgramResponse.builder()
                .id(program.getId())
                .code(program.getCode())
                .name(program.getName())
                .modality(program.getModality())
                .schedule(program.getSchedule())
                .duration(program.getDuration())
                .degreeAwarded(program.getDegreeAwarded())
                .status(program.getStatus())
                .facultyId(program.getFaculty().getId())
                .facultyName(program.getFaculty().getName())
                .build();
    }

    @Override
    public ProgramResponse create(ProgramRequest request) {
        return toResponse(repo.save(toEntity(request)));
    }

    @Override
    public ProgramResponse update(Long id, ProgramRequest request) {
        Program program = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Program not found"));

        program.setCode(request.getCode());
        program.setName(request.getName());
        program.setModality(request.getModality());
        program.setSchedule(request.getSchedule());
        program.setDuration(request.getDuration());
        program.setDegreeAwarded(request.getDegreeAwarded());
        program.setStatus(request.getStatus());
        program.setFaculty(facultyRepo.findById(request.getFacultyId())
                .orElseThrow(() -> new RuntimeException("Faculty not found")));

        return toResponse(repo.save(program));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public ProgramResponse findById(Long id) {
        return repo.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Program not found"));
    }

    @Override
    public List<ProgramResponse> findAll() {
        return repo.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
    
}
