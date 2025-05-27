package com.corhuila.backend_sis_dis_2025_a.service.impl;

import java.util.stream.Collectors;
import java.util.List;

import com.corhuila.backend_sis_dis_2025_a.dto.request.FacultyRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.FacultyResponse;
import org.springframework.stereotype.Service;

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

    private Faculty toEntity(FacultyRequest request) {
        Campus campus = camRepo.findById(request.getCampusId())
                .orElseThrow(() -> new RuntimeException("Campus not found"));

        return Faculty.builder()
                .name(request.getName())
                .description(request.getDescription())
                .status(request.getStatus())
                .campus(campus)
                .build();
    }

    private FacultyResponse toResponse(Faculty entity) {
        return FacultyResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .status(entity.getStatus())
                .campusId(entity.getCampus().getId())
                .campusName(entity.getCampus().getName())
                .build();
    }

    @Override
    public FacultyResponse create(FacultyRequest request) {
        return toResponse(repo.save(toEntity(request)));
    }

    @Override
    public FacultyResponse update(Long id, FacultyRequest request) {
        Faculty faculty = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Faculty not found"));

        faculty.setName(request.getName());
        faculty.setDescription(request.getDescription());
        faculty.setStatus(request.getStatus());
        faculty.setCampus(camRepo.findById(request.getCampusId())
                .orElseThrow(() -> new RuntimeException("Campus not found")));

        return toResponse(repo.save(faculty));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public FacultyResponse findById(Long id) {
        return repo.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Faculty not found"));
    }

    @Override
    public List<FacultyResponse> findAll() {
        return repo.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
