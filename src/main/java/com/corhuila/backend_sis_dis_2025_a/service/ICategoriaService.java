package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.request.CategoriaRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.CategoriaResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.Categoria;

import java.util.List;

public interface ICategoriaService {
    CategoriaResponseDTO save(CategoriaRequestDTO dto);
    CategoriaResponseDTO update(Long id, CategoriaRequestDTO dto);
    List<CategoriaResponseDTO> getAll();
    CategoriaResponseDTO getById(Long id);
    void delete(Long id);
    Categoria getCategoriaByIdEntity(Long id);
}
