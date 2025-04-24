package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.CampusDto;
import java.util.List;

public interface ICampusService {

    CampusDto create(CampusDto dto);
    CampusDto update(Long id, CampusDto dto);
    void delete(Long id);
    CampusDto findById(Long id);
    List<CampusDto> findAll();
    
}
