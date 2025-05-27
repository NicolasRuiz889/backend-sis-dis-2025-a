package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.request.UserRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.UserResponse;

import java.util.List;

public interface IUserService {
    UserResponse create(UserRequest request);
    UserResponse update(Long id, UserRequest request);
    void delete(Long id);
    UserResponse findById(Long id);
    List<UserResponse> findAll();
}
