package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.entity.Facultad;

import java.util.List;

public interface IFacultadService {
    Facultad saveFacultad(Facultad facultad);
    Facultad updateFacultad(Long id, Facultad facultad);
    List<Facultad> getAllFacultades();
    Facultad getFacultadById(Long id);
    void deleteFacultad(Long id);
}
