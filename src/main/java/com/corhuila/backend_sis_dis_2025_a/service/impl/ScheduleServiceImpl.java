package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.ScheduleDto;
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

    private ScheduleDto toDto(Schedule e) {
        return ScheduleDto.builder()
                .id(e.getId())
                .dayOfWeek(e.getDayOfWeek())
                .startTime(e.getStartTime())
                .endTime(e.getEndTime())
                .group(e.getGroup() != null ? e.getGroup().getId() : null)
                .build();
    }

    private Schedule toEntity(ScheduleDto d) {
        Group group = groupRepo.findById(d.getGroup())
                .orElseThrow(() -> new RuntimeException("Group not found"));

        return Schedule.builder()
                .id(d.getId())
                .dayOfWeek(d.getDayOfWeek())
                .startTime(d.getStartTime())
                .endTime(d.getEndTime())
                .group(group)
                .build();
    }

    @Override
    public ScheduleDto create(ScheduleDto dto) {
        return toDto(repo.save(toEntity(dto)));
    }

    @Override
    public ScheduleDto update(Long id, ScheduleDto dto) {
        Schedule schedule = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));

        schedule.setDayOfWeek(dto.getDayOfWeek());
        schedule.setStartTime(dto.getStartTime());
        schedule.setEndTime(dto.getEndTime());

        Group group = groupRepo.findById(dto.getGroup())
                .orElseThrow(() -> new RuntimeException("Group not found"));

        schedule.setGroup(group);

        return toDto(repo.save(schedule));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public ScheduleDto findById(Long id) {
        return repo.findById(id).map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
    }

    @Override
    public List<ScheduleDto> findAll() {
        return repo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }
}

