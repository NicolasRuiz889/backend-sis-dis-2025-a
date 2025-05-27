package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.request.CampusRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.CampusResponse;

import java.util.List;

public interface ICampusService {

    CampusResponse create(CampusRequest request);
    CampusResponse update(Long id, CampusRequest request);
    void delete(Long id);
    CampusResponse findById(Long id);
    List<CampusResponse> findAll();
    
}
