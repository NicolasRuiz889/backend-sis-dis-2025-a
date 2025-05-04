package com.corhuila.backend_sis_dis_2025_a.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.corhuila.backend_sis_dis_2025_a.dto.CampusDto;
import com.corhuila.backend_sis_dis_2025_a.entity.Campus;
import com.corhuila.backend_sis_dis_2025_a.repository.ICampusRepository;
import com.corhuila.backend_sis_dis_2025_a.service.ICampusService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CampusServiceImpl implements ICampusService {


    private final ICampusRepository repo;
    

    private CampusDto toDto(Campus e) {
        return CampusDto.builder()
            .id(e.getId())
            .name(e.getName())
            .address(e.getAddress())
            .phone(e.getPhone())
            .status(e.getStatus())
            .build();
    }

    private Campus toEntity(CampusDto d) {
        return Campus.builder()
                .id(d.getId())
                .name(d.getName())
                .address(d.getAddress())
                .phone(d.getPhone())
                .status(d.getStatus())
                .build();
    }

    @Override public CampusDto create(CampusDto dto) {
        return toDto(repo.save(toEntity(dto)));
    }

    
    @Override public CampusDto update(Long id, CampusDto dto) {
        Campus e = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Campus not found"));
        e.setName(dto.getName());
        e.setAddress(dto.getAddress());
        e.setPhone(dto.getPhone());
        e.setStatus(dto.getStatus());
        return toDto(repo.save(e));
    }
    @Override public void delete(Long id) { repo.deleteById(id); }
    @Override public CampusDto findById(Long id) {
        return repo.findById(id).map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Campus not found"));
    }
    @Override public List<CampusDto> findAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
    
}
