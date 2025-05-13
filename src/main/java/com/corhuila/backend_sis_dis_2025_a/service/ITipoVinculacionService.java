package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.entity.TipoVinculacion;

import java.util.List;

public interface ITipoVinculacionService {
    TipoVinculacion saveTipoVinculacion(TipoVinculacion tipoVinculacion);
    TipoVinculacion updateTipoVinculacion(Long id, TipoVinculacion tipoVinculacion);
    List<TipoVinculacion> getAllTipoVinculaciones();
    TipoVinculacion getTipoVinculacionById(Long id);
    void deleteTipoVinculacion(Long id);
}
