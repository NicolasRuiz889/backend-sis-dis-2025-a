package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.entity.Asignatura;

import java.util.List;

public interface IAsignaturaService {
    Asignatura saveAsignatura(Asignatura asignatura);
    Asignatura updateAsignatura(Long id, Asignatura asignatura);
    List<Asignatura> getAllAsignaturas();
    Asignatura getAsignaturaById(Long id);
    void deleteAsignatura(Long id);
}
