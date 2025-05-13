package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.entity.Programa;

import java.util.List;

public interface IProgramaService {
    Programa savePrograma(Programa programa);
    Programa updatePrograma(Long id, Programa programa);
    List<Programa> getAllProgramas();
    Programa getProgramaById(Long id);
    void deletePrograma(Long id);
}
