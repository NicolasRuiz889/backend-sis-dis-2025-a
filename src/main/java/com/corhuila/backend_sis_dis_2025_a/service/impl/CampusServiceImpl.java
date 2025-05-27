package com.corhuila.backend_sis_dis_2025_a.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.corhuila.backend_sis_dis_2025_a.dto.request.CampusRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.CampusResponse;
import org.springframework.stereotype.Service;

import com.corhuila.backend_sis_dis_2025_a.entity.Campus;
import com.corhuila.backend_sis_dis_2025_a.repository.ICampusRepository;
import com.corhuila.backend_sis_dis_2025_a.service.ICampusService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CampusServiceImpl implements ICampusService {

    private final ICampusRepository repo;

    private Campus toEntity(CampusRequest request) {
        return Campus.builder()
                .name(request.getName())
                .address(request.getAddress())
                .phone(request.getPhone())
                .status(request.getStatus())
                .build();
    }

    private CampusResponse toResponse(Campus entity) {
        return CampusResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(entity.getAddress())
                .phone(entity.getPhone())
                .status(entity.getStatus())
                .build();
    }

    @Override
    public CampusResponse create(CampusRequest request) {
        return toResponse(repo.save(toEntity(request)));
    }

    @Override
    public CampusResponse update(Long id, CampusRequest request) {
        Campus campus = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Campus not found"));

        campus.setName(request.getName());
        campus.setAddress(request.getAddress());
        campus.setPhone(request.getPhone());
        campus.setStatus(request.getStatus());

        return toResponse(repo.save(campus));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public CampusResponse findById(Long id) {
        return repo.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Campus not found"));
    }

    @Override
    public List<CampusResponse> findAll() {
        return repo.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
    
}
