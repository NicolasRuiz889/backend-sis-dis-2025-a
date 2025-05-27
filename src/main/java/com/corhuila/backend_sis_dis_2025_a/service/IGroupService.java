package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.request.GroupRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.GroupResponse;

import java.util.List;

public interface IGroupService {
    GroupResponse create(GroupRequest request);
    GroupResponse update(Long id, GroupRequest request);
    void delete(Long id);
    GroupResponse findById(Long id);
    List<GroupResponse> findAll();
}