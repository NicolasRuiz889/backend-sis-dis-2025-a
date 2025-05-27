package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.request.ClassOrientationRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.ClassOrientationResponse;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.corhuila.backend_sis_dis_2025_a.entity.ClassOrientation;
import com.corhuila.backend_sis_dis_2025_a.repository.ICampusRepository;
import com.corhuila.backend_sis_dis_2025_a.repository.IClassOrientationRepository;
import com.corhuila.backend_sis_dis_2025_a.repository.IGroupRepository;
import com.corhuila.backend_sis_dis_2025_a.repository.IProgramRepository;
import com.corhuila.backend_sis_dis_2025_a.repository.ISubjectRepository;
import com.corhuila.backend_sis_dis_2025_a.service.IClassOrientationService;

@Service
@RequiredArgsConstructor
public class ClassOrientationServiceImpl implements IClassOrientationService {

        private final IClassOrientationRepository repo;
        private final ISubjectRepository subjectRepo;
        private final IProgramRepository programRepo;
        private final IGroupRepository groupRepo;
        private final ICampusRepository campusRepo;

        private ClassOrientation toEntity(ClassOrientationRequest request) {
                return ClassOrientation.builder()
                        .subject(subjectRepo.findById(request.getSubjectId())
                                .orElseThrow(() -> new RuntimeException("Subject not found")))
                        .program(programRepo.findById(request.getProgramId())
                                .orElseThrow(() -> new RuntimeException("Program not found")))
                        .group(groupRepo.findById(request.getGroupId())
                                .orElseThrow(() -> new RuntimeException("Group not found")))
                        .campus(campusRepo.findById(request.getCampusId())
                                .orElseThrow(() -> new RuntimeException("Campus not found")))
                        .weeklyHours(request.getWeeklyHours())
                        .semesterHours(request.getSemesterHours())
                        .build();
        }

        private ClassOrientationResponse toResponse(ClassOrientation entity) {
                return ClassOrientationResponse.builder()
                        .id(entity.getId())
                        .subjectId(entity.getSubject().getId())
                        .subjectName(entity.getSubject().getName())
                        .programId(entity.getProgram().getId())
                        .programName(entity.getProgram().getName())
                        .groupId(entity.getGroup().getId())
                        .campusId(entity.getCampus().getId())
                        .campusName(entity.getCampus().getName())
                        .weeklyHours(entity.getWeeklyHours())
                        .semesterHours(entity.getSemesterHours())
                        .build();
        }

        @Override
        public ClassOrientationResponse create(ClassOrientationRequest request) {
                return toResponse(repo.save(toEntity(request)));
        }

        @Override
        public ClassOrientationResponse update(Long id, ClassOrientationRequest request) {
                ClassOrientation entity = repo.findById(id)
                        .orElseThrow(() -> new RuntimeException("ClassOrientation not found"));

                entity.setSubject(subjectRepo.findById(request.getSubjectId())
                        .orElseThrow(() -> new RuntimeException("Subject not found")));
                entity.setProgram(programRepo.findById(request.getProgramId())
                        .orElseThrow(() -> new RuntimeException("Program not found")));
                entity.setGroup(groupRepo.findById(request.getGroupId())
                        .orElseThrow(() -> new RuntimeException("Group not found")));
                entity.setCampus(campusRepo.findById(request.getCampusId())
                        .orElseThrow(() -> new RuntimeException("Campus not found")));
                entity.setWeeklyHours(request.getWeeklyHours());
                entity.setSemesterHours(request.getSemesterHours());

                return toResponse(repo.save(entity));
        }

        @Override
        public void delete(Long id) {
                repo.deleteById(id);
        }

        @Override
        public ClassOrientationResponse findById(Long id) {
                return repo.findById(id)
                        .map(this::toResponse)
                        .orElseThrow(() -> new RuntimeException("ClassOrientation not found"));
        }

        @Override
        public List<ClassOrientationResponse> findAll() {
                return repo.findAll().stream()
                        .map(this::toResponse)
                        .collect(Collectors.toList());
        }

        @Override
        public List<ClassOrientationResponse> findByProfesorId(Long profesorId) {
                return repo.findAll().stream()
                        .map(this::toResponse)
                        .collect(Collectors.toList());
        }

}
