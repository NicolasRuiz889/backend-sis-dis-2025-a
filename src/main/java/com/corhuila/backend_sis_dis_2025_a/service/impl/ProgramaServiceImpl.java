package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.entity.Facultad;
import com.corhuila.backend_sis_dis_2025_a.entity.Programa;
import com.corhuila.backend_sis_dis_2025_a.exception.ResourceNotFoundException;
import com.corhuila.backend_sis_dis_2025_a.repository.ProgramaRepository;
import com.corhuila.backend_sis_dis_2025_a.service.IFacultadService;
import com.corhuila.backend_sis_dis_2025_a.service.IProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramaServiceImpl implements IProgramaService {

    @Autowired
    private ProgramaRepository programaRepository;

    @Autowired
    private IFacultadService facultadService;

    @Override
    public Programa savePrograma(Programa programa) {
        Facultad facultad = facultadService.getFacultadById(programa.getFacultad().getIdFacultad());
        programa.setFacultad(facultad);
        return programaRepository.save(programa);
    }

    @Override
    public Programa updatePrograma(Long id, Programa programa) {
        Programa existingPrograma = getProgramaById(id);
        existingPrograma.setNombrePrograma(programa.getNombrePrograma());
        existingPrograma.setFacultad(programa.getFacultad());
        return programaRepository.save(existingPrograma);
    }

    @Override
    public List<Programa> getAllProgramas() {
        return programaRepository.findAll();
    }

    @Override
    public Programa getProgramaById(Long id) {
        return programaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Programa", "id", id));
    }

    @Override
    public void deletePrograma(Long id) {
        Programa programa = getProgramaById(id);
        programaRepository.delete(programa);
    }

}
