package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.request.ScheduleRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.ScheduleResponse;
import com.corhuila.backend_sis_dis_2025_a.entity.Group;
import com.corhuila.backend_sis_dis_2025_a.entity.Schedule;
import com.corhuila.backend_sis_dis_2025_a.repository.IGroupRepository;
import com.corhuila.backend_sis_dis_2025_a.repository.IScheduleRepository;
import com.corhuila.backend_sis_dis_2025_a.service.IScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements IScheduleService {

    private final IScheduleRepository repo;
    private final IGroupRepository groupRepo;

    private Schedule toEntity(ScheduleRequest request) {
        Group group = groupRepo.findById(request.getGroupId())
                .orElseThrow(() -> new RuntimeException("Group not found"));

        return Schedule.builder()
                .dayOfWeek(request.getDayOfWeek())
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .group(group)
                .build();
    }

    private ScheduleResponse toResponse(Schedule schedule) {
        return ScheduleResponse.builder()
                .id(schedule.getId())
                .dayOfWeek(schedule.getDayOfWeek())
                .startTime(schedule.getStartTime())
                .endTime(schedule.getEndTime())
                .groupId(schedule.getGroup().getId())
                .groupCode(schedule.getGroup().getCode())
                .build();
    }

    @Override
    public ScheduleResponse create(ScheduleRequest request) {
        return toResponse(repo.save(toEntity(request)));
    }

    @Override
    public ScheduleResponse update(Long id, ScheduleRequest request) {
        Schedule schedule = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));

        schedule.setDayOfWeek(request.getDayOfWeek());
        schedule.setStartTime(request.getStartTime());
        schedule.setEndTime(request.getEndTime());
        schedule.setGroup(groupRepo.findById(request.getGroupId())
                .orElseThrow(() -> new RuntimeException("Group not found")));

        return toResponse(repo.save(schedule));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public ScheduleResponse findById(Long id) {
        return repo.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
    }

    @Override
    public List<ScheduleResponse> findAll() {
        return repo.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}

