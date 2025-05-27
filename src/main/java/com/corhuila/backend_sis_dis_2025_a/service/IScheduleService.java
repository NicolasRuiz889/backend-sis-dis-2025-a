package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.request.ScheduleRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.ScheduleResponse;

import java.util.List;

public interface IScheduleService {
    ScheduleResponse create(ScheduleRequest request);
    ScheduleResponse update(Long id, ScheduleRequest request);
    void delete(Long id);
    ScheduleResponse findById(Long id);
    List<ScheduleResponse> findAll();
}
