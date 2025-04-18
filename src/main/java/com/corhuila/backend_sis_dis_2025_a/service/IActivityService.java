// src/main/java/com/corhuila/backend_sis_dis_2025_a/service/IActivityService.java
package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.ActivityDto;
import java.util.List;

public interface IActivityService {
    ActivityDto create(ActivityDto dto);
    ActivityDto update(Long id, ActivityDto dto);
    void delete(Long id);
    ActivityDto findById(Long id);
    List<ActivityDto> findAll();
}
