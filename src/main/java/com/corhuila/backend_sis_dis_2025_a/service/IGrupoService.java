package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.entity.Grupo;

import java.util.List;

public interface IGrupoService {
    Grupo saveGrupo(Grupo grupo);
    Grupo updateGrupo(Long id, Grupo grupo);
    List<Grupo> getAllGrupos();
    Grupo getGrupoById(Long id);
    void deleteGrupo(Long id);
}
