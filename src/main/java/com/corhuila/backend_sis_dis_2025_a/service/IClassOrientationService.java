package com.corhuila.backend_sis_dis_2025_a.service;

import java.util.List;
import com.corhuila.backend_sis_dis_2025_a.dto.request.ClassOrientationRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.ClassOrientationResponse;

public interface IClassOrientationService {
    ClassOrientationResponse create(ClassOrientationRequest request);
    ClassOrientationResponse update(Long id, ClassOrientationRequest request);
    void delete(Long id);
    ClassOrientationResponse findById(Long id);
    List<ClassOrientationResponse> findAll();
    List<ClassOrientationResponse> findByProfesorId(Long profesorId);
}
