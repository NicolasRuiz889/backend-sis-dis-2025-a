package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.request.SubjectRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.SubjectResponse;

import java.util.List;

public interface ISubjectService {
    SubjectResponse create(SubjectRequest request);
    SubjectResponse update(Long id, SubjectRequest request);
    void delete(Long id);
    SubjectResponse findById(Long id);
    List<SubjectResponse> findAll();
}

