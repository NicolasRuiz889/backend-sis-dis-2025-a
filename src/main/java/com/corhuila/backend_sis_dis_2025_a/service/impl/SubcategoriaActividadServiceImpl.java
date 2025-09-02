package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.request.SubcategoriaActividadRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.SubcategoriaActividadResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.Categoria;
import com.corhuila.backend_sis_dis_2025_a.entity.SubcategoriaActividad;
import com.corhuila.backend_sis_dis_2025_a.exception.ResourceNotFoundException;
import com.corhuila.backend_sis_dis_2025_a.repository.SubcategoriaActividadRepository;
import com.corhuila.backend_sis_dis_2025_a.service.ICategoriaService;
import com.corhuila.backend_sis_dis_2025_a.service.ISubcategoriaActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubcategoriaActividadServiceImpl implements ISubcategoriaActividadService {

    @Autowired
    private SubcategoriaActividadRepository repository;

    @Autowired
    private ICategoriaService categoriaService;

    @Override
    public SubcategoriaActividadResponseDTO save(SubcategoriaActividadRequestDTO dto) {
        Categoria categoria = categoriaService.getCategoriaByIdEntity(dto.getCategoriaId());

        SubcategoriaActividad entity = new SubcategoriaActividad();
        entity.setNombreSubcategoria(dto.getNombreSubcategoria());
        entity.setDescripcion(dto.getDescripcion());
        entity.setEstado(dto.getEstado());
        entity.setCategoria(categoria);

        return mapToResponse(repository.save(entity));
    }

    @Override
    public SubcategoriaActividadResponseDTO update(Long id, SubcategoriaActividadRequestDTO dto) {
        SubcategoriaActividad entity = getSubcategoriaByIdEntity(id);
        Categoria categoria = categoriaService.getCategoriaByIdEntity(dto.getCategoriaId());

        entity.setNombreSubcategoria(dto.getNombreSubcategoria());
        entity.setDescripcion(dto.getDescripcion());
        entity.setEstado(dto.getEstado());
        entity.setCategoria(categoria);

        return mapToResponse(repository.save(entity));
    }

    @Override
    public List<SubcategoriaActividadResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public SubcategoriaActividadResponseDTO getById(Long id) {
        return mapToResponse(getSubcategoriaByIdEntity(id));
    }

    @Override
    public void delete(Long id) {
        repository.delete(getSubcategoriaByIdEntity(id));
    }

    @Override
    public SubcategoriaActividad getSubcategoriaByIdEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SubcategoriaActividad", "id", id));
    }

    private SubcategoriaActividadResponseDTO mapToResponse(SubcategoriaActividad entity) {
        SubcategoriaActividadResponseDTO dto = new SubcategoriaActividadResponseDTO();
        dto.setIdSubcategoria(entity.getIdSubcategoria());
        dto.setNombreSubcategoria(entity.getNombreSubcategoria());
        dto.setDescripcion(entity.getDescripcion());
        dto.setEstado(entity.getEstado());
        dto.setCategoriaNombre(entity.getCategoria() != null ? entity.getCategoria().getNombreCategoria() : null);
        return dto;
    }
}
