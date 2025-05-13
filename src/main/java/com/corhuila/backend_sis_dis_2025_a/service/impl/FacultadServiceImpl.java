package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.entity.Facultad;
import com.corhuila.backend_sis_dis_2025_a.entity.Sede;
import com.corhuila.backend_sis_dis_2025_a.exception.ResourceNotFoundException;
import com.corhuila.backend_sis_dis_2025_a.repository.FacultadRepository;
import com.corhuila.backend_sis_dis_2025_a.service.IFacultadService;
import com.corhuila.backend_sis_dis_2025_a.service.ISedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultadServiceImpl implements IFacultadService {

    @Autowired
    private FacultadRepository facultadRepository;

    @Autowired
    private ISedeService sedeService;

    @Override
    public Facultad saveFacultad(Facultad facultad) {
        Sede sede = sedeService.getSedeById(facultad.getSede().getIdSede());
        facultad.setSede(sede);
        return facultadRepository.save(facultad);
    }

    @Override
    public Facultad updateFacultad(Long id, Facultad facultad) {
        Facultad existingFacultad = getFacultadById(id);
        existingFacultad.setNombreFacultad(facultad.getNombreFacultad());
        existingFacultad.setSede(facultad.getSede());
        return facultadRepository.save(existingFacultad);
    }

    @Override
    public List<Facultad> getAllFacultades() {
        return facultadRepository.findAll();
    }

    @Override
    public Facultad getFacultadById(Long id) {
        return facultadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Facultad", "id", id));
    }

    @Override
    public void deleteFacultad(Long id) {
        Facultad facultad = getFacultadById(id);
        facultadRepository.delete(facultad);
    }

}
