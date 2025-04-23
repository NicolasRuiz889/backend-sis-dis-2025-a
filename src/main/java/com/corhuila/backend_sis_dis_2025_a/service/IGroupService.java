package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.GroupDto;
import java.util.List;

public interface IGroupService {

    GroupDto create(GroupDto dto);
    GroupDto update(Long id, GroupDto dto);
    void delete(Long id);
    GroupDto findById(Long id);
    List<GroupDto> findAll();

    
}
