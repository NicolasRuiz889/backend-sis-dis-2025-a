package com.corhuila.backend_sis_dis_2025_a.service.impl;

import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.corhuila.backend_sis_dis_2025_a.dto.ClassOrientationDto;

import com.corhuila.backend_sis_dis_2025_a.entity.ClassOrientation;

import com.corhuila.backend_sis_dis_2025_a.repository.ICampusRepository;
import com.corhuila.backend_sis_dis_2025_a.repository.IClassOrientationRepository;

import com.corhuila.backend_sis_dis_2025_a.repository.IGroupRepository;
import com.corhuila.backend_sis_dis_2025_a.repository.IProgramRepository;
import com.corhuila.backend_sis_dis_2025_a.repository.ISubjectRepository;
import com.corhuila.backend_sis_dis_2025_a.repository.SubcategoryActivityRepository;
import com.corhuila.backend_sis_dis_2025_a.service.IClassOrientationService;

@Service
@RequiredArgsConstructor
public class ClassOrientationServiceImpl implements IClassOrientationService {

        private final IClassOrientationRepository repo;
        private final ISubjectRepository subjectRepo;
        private final IGroupRepository groupRepo;
        private final ICampusRepository campusRepo;
        private final IProgramRepository programRepo;
        private final SubcategoryActivityRepository subRepo;

        private ClassOrientationDto toDto(ClassOrientation e) {
                return ClassOrientationDto.builder()
                                .id(e.getId())
                                .subjectId(e.getSubject().getId())
                                .subjectName(e.getSubject().getName())
                                .groupId(e.getGroup().getId())
                                .groupName(e.getGroup().getCode())
                                .campusId(e.getCampus().getId())
                                .campusName(e.getCampus().getName())
                                .programId(e.getProgram().getId())
                                .programName(e.getProgram().getName())
                                .weeklyHours(e.getWeeklyHours())
                                .semesterHours(e.getSemesterHours())
                                //.subcategoryId(e.getSubcategory().getId())
                                //.subcategoryName(e.getSubcategory().getName())
                                //.categoryName(e.getSubcategory().getCategory().getName())
                                .build();
        }

        private ClassOrientation toEntity(ClassOrientationDto d) {
                /*SubcategoryActivity sub = subRepo.findById(d.getSubcategoryId())
                                .orElseThrow(() -> new RuntimeException("Subcategory not found"));*/

                return ClassOrientation.builder()
                                .id(d.getId())
                                .subject(subjectRepo.findById(d.getSubjectId())
                                                .orElseThrow(() -> new RuntimeException("Subject not found")))
                                .group(groupRepo.findById(d.getGroupId())
                                                .orElseThrow(() -> new RuntimeException("Group not found")))
                                .campus(campusRepo.findById(d.getCampusId())
                                                .orElseThrow(() -> new RuntimeException("Campus not found")))
                                .program(programRepo.findById(d.getProgramId())
                                                .orElseThrow(() -> new RuntimeException("Program not found")))
                                .weeklyHours(d.getWeeklyHours())
                                .semesterHours(d.getWeeklyHours() * 16) // Calculo de horas semestrales
                                //.subcategory(sub)

                                .build();
        }

        @Override
        public ClassOrientationDto create(ClassOrientationDto dto) {
                return toDto(repo.save(toEntity(dto)));
        }

        @Override
        public ClassOrientationDto update(Long id, ClassOrientationDto dto) {
                ClassOrientation e = repo.findById(id)
                                .orElseThrow(() -> new RuntimeException("Class Orientation not found"));

                e.setWeeklyHours(dto.getWeeklyHours());
                e.setSemesterHours(dto.getWeeklyHours() * 16); // Calculo de horas semestrales

                e.setSubject(subjectRepo.findById(dto.getSubjectId())
                                .orElseThrow(() -> new RuntimeException("Subject not found")));

                e.setGroup(groupRepo.findById(dto.getGroupId())
                                .orElseThrow(() -> new RuntimeException("Group not found")));

                e.setCampus(campusRepo.findById(dto.getCampusId())
                                .orElseThrow(() -> new RuntimeException("Campus not found")));

                e.setProgram(programRepo.findById(dto.getProgramId())
                                .orElseThrow(() -> new RuntimeException("Program not found")));

                //e.setSubcategory(subRepo.findById(dto.getSubcategoryId())
                               // .orElseThrow(() -> new RuntimeException("Subcategory not found")));

                return toDto(repo.save(e));
        }

        @Override
        public void delete(Long id) {
                repo.deleteById(id);
        }

        @Override
        public ClassOrientationDto findById(Long id) {
                return repo.findById(id).map(this::toDto)
                                .orElseThrow(() -> new RuntimeException("Class Orientation not found"));
        }

        @Override
        public List<ClassOrientationDto> findAll() {
                return repo.findAll().stream()
                                .map(this::toDto)
                                .collect(Collectors.toList());
        }

        // Método para obtener actividades por ID de profesor
        @Override
        public List<ClassOrientationDto> findByProfesorId(Long profesorId) {
                return repo.findAll().stream()
                                .map(this::toDto)
                                .collect(Collectors.toList());
        }

}
