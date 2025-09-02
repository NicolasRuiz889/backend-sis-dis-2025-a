package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.request.TipoVinculacionRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.TipoVinculacionResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.TipoVinculacion;
import com.corhuila.backend_sis_dis_2025_a.exception.ResourceNotFoundException;
import com.corhuila.backend_sis_dis_2025_a.repository.TipoVinculacionRepository;
import com.corhuila.backend_sis_dis_2025_a.service.ITipoVinculacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoVinculacionServiceImpl implements ITipoVinculacionService {

    @Autowired
    private TipoVinculacionRepository tipoVinculacionRepository;

    @Override
    public TipoVinculacionResponseDTO saveTipoVinculacion(TipoVinculacionRequestDTO dto) {
        TipoVinculacion entity = new TipoVinculacion();
        entity.setNombreVinculacion(dto.getNombreVinculacion());
        entity.setHorasMin(dto.getHorasMin());
        entity.setHorasMax(dto.getHorasMax());
        return mapToResponse(tipoVinculacionRepository.save(entity));
    }

    @Override
    public TipoVinculacionResponseDTO updateTipoVinculacion(Long id, TipoVinculacionRequestDTO dto) {
        TipoVinculacion entity = getTipoVinculacionByIdEntity(id);
        entity.setNombreVinculacion(dto.getNombreVinculacion());
        entity.setHorasMin(dto.getHorasMin());
        entity.setHorasMax(dto.getHorasMax());
        return mapToResponse(tipoVinculacionRepository.save(entity));
    }

    @Override
    public List<TipoVinculacionResponseDTO> getAllTipoVinculaciones() {
        return tipoVinculacionRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public TipoVinculacionResponseDTO getTipoVinculacionById(Long id) {
        return mapToResponse(getTipoVinculacionByIdEntity(id));
    }

    @Override
    public void deleteTipoVinculacion(Long id) {
        TipoVinculacion tipoVinculacion = getTipoVinculacionByIdEntity(id);
        tipoVinculacionRepository.delete(tipoVinculacion);
    }

    @Override
    public TipoVinculacion getTipoVinculacionByIdEntity(Long id) {
        return tipoVinculacionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TipoVinculacion", "id", id));
    }

    private TipoVinculacionResponseDTO mapToResponse(TipoVinculacion entity) {
        TipoVinculacionResponseDTO dto = new TipoVinculacionResponseDTO();
        dto.setIdVinculacion(entity.getIdVinculacion());
        dto.setNombreVinculacion(entity.getNombreVinculacion());
        dto.setHorasMin(entity.getHorasMin());
        dto.setHorasMax(entity.getHorasMax());
        return dto;
    }

}
