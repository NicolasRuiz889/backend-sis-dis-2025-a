package com.corhuila.backend_sis_dis_2025_a.service;
import java.util.List;

import com.corhuila.backend_sis_dis_2025_a.dto.request.ProgramRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.ProgramResponse;

public interface IProgramService {
    ProgramResponse create(ProgramRequest request);
    ProgramResponse update(Long id, ProgramRequest request);
    void delete(Long id);
    ProgramResponse findById(Long id);
    List<ProgramResponse> findAll();
}
