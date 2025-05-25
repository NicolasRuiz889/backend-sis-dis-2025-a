package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.GroupDto;
import com.corhuila.backend_sis_dis_2025_a.entity.Group;
import com.corhuila.backend_sis_dis_2025_a.entity.Subject;
import com.corhuila.backend_sis_dis_2025_a.repository.IGroupRepository;
import com.corhuila.backend_sis_dis_2025_a.repository.ISubjectRepository;
import com.corhuila.backend_sis_dis_2025_a.service.IGroupService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements IGroupService {

    private final IGroupRepository groupRepository;
    private final ISubjectRepository subjectRepository;

    private GroupDto toDto(Group e) {
        return GroupDto.builder()
                .id(e.getId())
                .code(e.getCode())
                .period(e.getPeriod())
                .status(e.getStatus())
                .subjectId(e.getSubject().getId())
                .build();
    }


    private Group toEntity(GroupDto d) {
        Subject subject = subjectRepository.findById(d.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subjet not found"));
        return Group.builder()
                .id(d.getId())
                .code(d.getCode())
                .period(d.getPeriod())
                .status(d.getStatus())
                .subject(subject)
                .build();
    }

    @Override public GroupDto create(GroupDto dto) {
        return toDto(groupRepository.save(toEntity(dto)));
    }
    @Override public GroupDto update(Long id, GroupDto dto) {
        Group e = groupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Group not found"));
        e.setCode(dto.getCode());
        e.setPeriod(dto.getPeriod());
        e.setStatus(dto.getStatus());
        e.setSubject(subjectRepository.findById(dto.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found")));
        return toDto(groupRepository.save(e));
    }
    @Override public void delete(Long id) { 
        groupRepository.deleteById(id); 
    }
    
    @Override public GroupDto findById(Long id) {
        return groupRepository.findById(id).map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Group not found"));
    }
    @Override public List<GroupDto> findAll() {
        return groupRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

}
