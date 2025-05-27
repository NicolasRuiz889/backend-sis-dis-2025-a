package com.corhuila.backend_sis_dis_2025_a.service;
import java.util.List;

import com.corhuila.backend_sis_dis_2025_a.dto.request.FacultyRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.FacultyResponse;

public interface IFacultyService {
    FacultyResponse create(FacultyRequest request);
    FacultyResponse update(Long id, FacultyRequest request);
    void delete(Long id);
    FacultyResponse findById(Long id);
    List<FacultyResponse> findAll();
}
