package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.request.TipoVinculacionRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.TipoVinculacionResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.TipoVinculacion;

import java.util.List;

public interface ITipoVinculacionService {
    TipoVinculacionResponseDTO saveTipoVinculacion(TipoVinculacionRequestDTO dto);
    TipoVinculacionResponseDTO updateTipoVinculacion(Long id, TipoVinculacionRequestDTO dto);
    List<TipoVinculacionResponseDTO> getAllTipoVinculaciones();
    TipoVinculacionResponseDTO getTipoVinculacionById(Long id);
    void deleteTipoVinculacion(Long id);
    TipoVinculacion getTipoVinculacionByIdEntity(Long id);
}
