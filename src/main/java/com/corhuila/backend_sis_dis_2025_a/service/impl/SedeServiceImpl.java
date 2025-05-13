package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.entity.Sede;
import com.corhuila.backend_sis_dis_2025_a.exception.ResourceNotFoundException;
import com.corhuila.backend_sis_dis_2025_a.repository.SedeRepository;
import com.corhuila.backend_sis_dis_2025_a.service.ISedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SedeServiceImpl implements ISedeService {

    @Autowired
    private SedeRepository sedeRepository;

    @Override
    public Sede saveSede(Sede sede) {
        if (sede.getNombreSede() == null || sede.getNombreSede().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la sede es obligatorio.");
        }
        return sedeRepository.save(sede);
    }

    @Override
    public Sede updateSede(Long id, Sede sede) {
        Sede existingSede = getSedeById(id);
        existingSede.setNombreSede(sede.getNombreSede());
        return sedeRepository.save(existingSede);
    }

    @Override
    public List<Sede> getAllSedes() {
        return sedeRepository.findAll();
    }

    @Override
    public Sede getSedeById(Long id) {
        return sedeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sede", "id", id));
    }

    @Override
    public void deleteSede(Long id) {
        Sede sede = getSedeById(id);
        sedeRepository.delete(sede);
    }
}
