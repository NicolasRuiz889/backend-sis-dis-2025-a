package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.request.GroupRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.GroupResponse;
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

    private Group toEntity(GroupRequest request) {
        Subject subject = subjectRepository.findById(request.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        return Group.builder()
                .code(request.getCode())
                .period(request.getPeriod())
                .status(request.getStatus())
                .subject(subject)
                .build();
    }

    private GroupResponse toResponse(Group group) {
        return GroupResponse.builder()
                .id(group.getId())
                .code(group.getCode())
                .period(group.getPeriod())
                .status(group.getStatus())
                .subjectId(group.getSubject().getId())
                .subjectName(group.getSubject().getName())
                .build();
    }

    @Override
    public GroupResponse create(GroupRequest request) {
        return toResponse(groupRepository.save(toEntity(request)));
    }

    @Override
    public GroupResponse update(Long id, GroupRequest request) {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Group not found"));

        group.setCode(request.getCode());
        group.setPeriod(request.getPeriod());
        group.setStatus(request.getStatus());
        group.setSubject(subjectRepository.findById(request.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found")));

        return toResponse(groupRepository.save(group));
    }

    @Override
    public void delete(Long id) {
        groupRepository.deleteById(id);
    }

    @Override
    public GroupResponse findById(Long id) {
        return groupRepository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Group not found"));
    }

    @Override
    public List<GroupResponse> findAll() {
        return groupRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

}
