package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.entity.TipoVinculacion;
import com.corhuila.backend_sis_dis_2025_a.exception.ResourceNotFoundException;
import com.corhuila.backend_sis_dis_2025_a.repository.TipoVinculacionRepository;
import com.corhuila.backend_sis_dis_2025_a.service.ITipoVinculacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoVinculacionServiceImpl implements ITipoVinculacionService {

    @Autowired
    private TipoVinculacionRepository tipoVinculacionRepository;

    @Override
    public TipoVinculacion saveTipoVinculacion(TipoVinculacion tipoVinculacion) {
        if (tipoVinculacion.getNombreVinculacion() == null || tipoVinculacion.getNombreVinculacion().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la vinculación es obligatorio.");
        }
        return tipoVinculacionRepository.save(tipoVinculacion);
    }

    @Override
    public TipoVinculacion updateTipoVinculacion(Long id, TipoVinculacion tipoVinculacion) {
        TipoVinculacion existingTipoVinculacion = getTipoVinculacionById(id);
        existingTipoVinculacion.setNombreVinculacion(tipoVinculacion.getNombreVinculacion());
        existingTipoVinculacion.setHorasMin(tipoVinculacion.getHorasMin());
        existingTipoVinculacion.setHorasMax(tipoVinculacion.getHorasMax());
        return tipoVinculacionRepository.save(existingTipoVinculacion);
    }

    @Override
    public List<TipoVinculacion> getAllTipoVinculaciones() {
        return tipoVinculacionRepository.findAll();
    }

    @Override
    public TipoVinculacion getTipoVinculacionById(Long id) {
        return tipoVinculacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TipoVinculacion", "id", id));
    }

    @Override
    public void deleteTipoVinculacion(Long id) {
        TipoVinculacion tipoVinculacion = getTipoVinculacionById(id);
        tipoVinculacionRepository.delete(tipoVinculacion);
    }

}
