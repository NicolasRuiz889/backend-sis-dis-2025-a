package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.ScheduleDto;
import java.util.List;

public interface IScheduleService {
    ScheduleDto create(ScheduleDto dto);
    ScheduleDto update(Long id, ScheduleDto dto);
    void delete(Long id);
    ScheduleDto findById(Long id);
    List<ScheduleDto> findAll();
}
