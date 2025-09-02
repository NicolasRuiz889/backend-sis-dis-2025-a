package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.request.CategoriaRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.CategoriaResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.Categoria;
import com.corhuila.backend_sis_dis_2025_a.exception.ResourceNotFoundException;
import com.corhuila.backend_sis_dis_2025_a.repository.CategoriaRepository;
import com.corhuila.backend_sis_dis_2025_a.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Override
    public CategoriaResponseDTO save(CategoriaRequestDTO dto) {
        Categoria entity = new Categoria();
        entity.setNombreCategoria(dto.getNombreCategoria());
        entity.setDescripcion(dto.getDescripcion());
        entity.setEstado(dto.getEstado());
        return mapToResponse(repository.save(entity));
    }

    @Override
    public CategoriaResponseDTO update(Long id, CategoriaRequestDTO dto) {
        Categoria entity = getCategoriaByIdEntity(id);
        entity.setNombreCategoria(dto.getNombreCategoria());
        entity.setDescripcion(dto.getDescripcion());
        entity.setEstado(dto.getEstado());
        return mapToResponse(repository.save(entity));
    }

    @Override
    public List<CategoriaResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaResponseDTO getById(Long id) {
        return mapToResponse(getCategoriaByIdEntity(id));
    }

    @Override
    public void delete(Long id) {
        repository.delete(getCategoriaByIdEntity(id));
    }

    @Override
    public Categoria getCategoriaByIdEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria", "id", id));
    }

    private CategoriaResponseDTO mapToResponse(Categoria entity) {
        CategoriaResponseDTO dto = new CategoriaResponseDTO();
        dto.setIdCategoria(entity.getIdCategoria());
        dto.setNombreCategoria(entity.getNombreCategoria());
        dto.setDescripcion(entity.getDescripcion());
        dto.setEstado(entity.getEstado());
        return dto;
    }

}
