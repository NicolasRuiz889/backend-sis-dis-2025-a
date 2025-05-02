package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.SubjectDto;
import com.corhuila.backend_sis_dis_2025_a.entity.Subject;
import com.corhuila.backend_sis_dis_2025_a.repository.SubjectRepository;
import com.corhuila.backend_sis_dis_2025_a.service.ISubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements ISubjectService {

    private final SubjectRepository subjectRepository;

  @Override
public List<SubjectDto> findAll() {
    return subjectRepository.findAll().stream()
            .map(subject -> new SubjectDto(subject.getId(), subject.getName()))
            .collect(Collectors.toList());
}

@Override
public SubjectDto findById(Long id) {
    Subject subject = subjectRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Subject not found"));
    return new SubjectDto(subject.getId(), subject.getName());
}

@Override
public SubjectDto save(SubjectDto subjectDto) {
    Subject subject = new Subject();
    subject.setName(subjectDto.getName());
    Subject saved = subjectRepository.save(subject);
    return new SubjectDto(saved.getId(), saved.getName());
}

@Override
public SubjectDto update(Long id, SubjectDto subjectDto) {
    Subject subject = subjectRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Subject not found"));
    subject.setName(subjectDto.getName());
    Subject updated = subjectRepository.save(subject);
    return new SubjectDto(updated.getId(), updated.getName());
}

@Override
public void delete(Long id) {
    subjectRepository.deleteById(id);
}
