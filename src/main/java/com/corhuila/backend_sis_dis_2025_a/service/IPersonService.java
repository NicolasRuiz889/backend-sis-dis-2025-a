package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.request.PersonRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.PersonResponse;

import java.util.List;

public interface IPersonService {
    PersonResponse create(PersonRequest request);
    PersonResponse update(Long id, PersonRequest request);
    void delete(Long id);
    PersonResponse findById(Long id);
    List<PersonResponse> findAll();
}
