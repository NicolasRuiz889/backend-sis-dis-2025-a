package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.request.ActividadRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.ActividadResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.Actividad;
import com.corhuila.backend_sis_dis_2025_a.entity.SubcategoriaActividad;
import com.corhuila.backend_sis_dis_2025_a.exception.ResourceNotFoundException;
import com.corhuila.backend_sis_dis_2025_a.repository.ActividadRepository;
import com.corhuila.backend_sis_dis_2025_a.service.IActividadService;
import com.corhuila.backend_sis_dis_2025_a.service.ISubcategoriaActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActividadServiceImpl implements IActividadService {

    @Autowired
    private ActividadRepository actividadRepository;

    @Autowired
    private ISubcategoriaActividadService subcategoriaService;

    @Override
    public ActividadResponseDTO saveActividad(ActividadRequestDTO dto) {
        SubcategoriaActividad sub = subcategoriaService.getSubcategoriaByIdEntity(dto.getSubcategoriaId());

        Actividad actividad = new Actividad();
        actividad.setNombreActividad(dto.getNombreActividad());
        actividad.setHoraSemanal(dto.getHoraSemanal());
        actividad.setHoraSemestre(dto.getHoraSemestre());
        actividad.setDescripcion(dto.getDescripcion());
        actividad.setProducto(dto.getProducto());
        actividad.setEstado(dto.getEstado());
        actividad.setSubcategoria(sub);

        return mapToResponse(actividadRepository.save(actividad));
    }

    @Override
    public ActividadResponseDTO updateActividad(Long id, ActividadRequestDTO dto) {
        Actividad actividad = getByIdEntity(id);
        SubcategoriaActividad sub = subcategoriaService.getSubcategoriaByIdEntity(dto.getSubcategoriaId());

        actividad.setNombreActividad(dto.getNombreActividad());
        actividad.setHoraSemanal(dto.getHoraSemanal());
        actividad.setHoraSemestre(dto.getHoraSemestre());
        actividad.setDescripcion(dto.getDescripcion());
        actividad.setProducto(dto.getProducto());
        actividad.setEstado(dto.getEstado());
        actividad.setSubcategoria(sub);

        return mapToResponse(actividadRepository.save(actividad));
    }

    @Override
    public List<ActividadResponseDTO> getAllActividades() {
        return actividadRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ActividadResponseDTO getActividadById(Long id) {
        return mapToResponse(getByIdEntity(id));
    }

    @Override
    public void deleteActividad(Long id) {
        actividadRepository.delete(getByIdEntity(id));
    }

    public Actividad getByIdEntity(Long id) {
        return actividadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Actividad", "id", id));
    }

    private ActividadResponseDTO mapToResponse(Actividad entity) {
        ActividadResponseDTO dto = new ActividadResponseDTO();
        dto.setIdActividad(entity.getIdActividad());
        dto.setNombreActividad(entity.getNombreActividad());
        dto.setHoraSemanal(entity.getHoraSemanal());
        dto.setHoraSemestre(entity.getHoraSemestre());
        dto.setDescripcion(entity.getDescripcion());
        dto.setProducto(entity.getProducto());
        dto.setEstado(entity.getEstado());
        dto.setSubcategoriaNombre(entity.getSubcategoria() != null ? entity.getSubcategoria().getNombreSubcategoria() : null);
        return dto;
    }
}
