package com.corhuila.backend_sis_dis_2025_a.service;

import java.util.List;
import com.corhuila.backend_sis_dis_2025_a.dto.request.ActivityRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.ActivityResponse;

public interface IActivityService {
    ActivityResponse create(ActivityRequest request);
    ActivityResponse update(Long id, ActivityRequest request);
    void delete(Long id);
    ActivityResponse findById(Long id);
    List<ActivityResponse> findAll();
    List<ActivityResponse> findByProfesorId(Long profesorId);
}
