package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.entity.Asignatura;
import com.corhuila.backend_sis_dis_2025_a.entity.Programa;
import com.corhuila.backend_sis_dis_2025_a.exception.ResourceNotFoundException;
import com.corhuila.backend_sis_dis_2025_a.repository.AsignaturaRepository;
import com.corhuila.backend_sis_dis_2025_a.service.IAsignaturaService;
import com.corhuila.backend_sis_dis_2025_a.service.IProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaServiceImpl implements IAsignaturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Autowired
    private IProgramaService programaService;

    @Override
    public Asignatura saveAsignatura(Asignatura asignatura) {
        Programa programa = programaService.getProgramaById(asignatura.getPrograma().getIdPrograma());
        asignatura.setPrograma(programa);
        return asignaturaRepository.save(asignatura);
    }

    @Override
    public Asignatura updateAsignatura(Long id, Asignatura asignatura) {
        Asignatura existingAsignatura = getAsignaturaById(id);
        existingAsignatura.setNombreAsignatura(asignatura.getNombreAsignatura());
        existingAsignatura.setHoraSemanal(asignatura.getHoraSemanal());
        existingAsignatura.setHoraSemestre(asignatura.getHoraSemestre());
        existingAsignatura.setPrograma(asignatura.getPrograma());
        return asignaturaRepository.save(existingAsignatura);
    }

    @Override
    public List<Asignatura> getAllAsignaturas() {
        return asignaturaRepository.findAll();
    }

    @Override
    public Asignatura getAsignaturaById(Long id) {
        return asignaturaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asignatura", "id", id));
    }

    @Override
    public void deleteAsignatura(Long id) {
        Asignatura asignatura = getAsignaturaById(id);
        asignaturaRepository.delete(asignatura);
    }

}
