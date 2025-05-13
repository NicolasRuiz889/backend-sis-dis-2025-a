package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.entity.Asignatura;
import com.corhuila.backend_sis_dis_2025_a.entity.Grupo;
import com.corhuila.backend_sis_dis_2025_a.exception.ResourceNotFoundException;
import com.corhuila.backend_sis_dis_2025_a.repository.GrupoRepository;
import com.corhuila.backend_sis_dis_2025_a.service.IAsignaturaService;
import com.corhuila.backend_sis_dis_2025_a.service.IGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoServiceImpl implements IGrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private IAsignaturaService asignaturaService;

    @Override
    public Grupo saveGrupo(Grupo grupo) {
        Asignatura asignatura = asignaturaService.getAsignaturaById(grupo.getAsignatura().getIdAsignatura());
        grupo.setAsignatura(asignatura);
        return grupoRepository.save(grupo);
    }

    @Override
    public Grupo updateGrupo(Long id, Grupo grupo) {
        Grupo existingGrupo = getGrupoById(id);
        existingGrupo.setNumeroGrupo(grupo.getNumeroGrupo());
        existingGrupo.setAsignatura(grupo.getAsignatura());
        return grupoRepository.save(existingGrupo);
    }

    @Override
    public List<Grupo> getAllGrupos() {
        return grupoRepository.findAll();
    }

    @Override
    public Grupo getGrupoById(Long id) {
        return grupoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Grupo", "id", id));
    }

    @Override
    public void deleteGrupo(Long id) {
        Grupo grupo = getGrupoById(id);
        grupoRepository.delete(grupo);
    }

}
