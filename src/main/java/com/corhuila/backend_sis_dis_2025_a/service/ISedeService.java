package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.entity.Sede;

import java.util.List;

public interface ISedeService {
    Sede saveSede(Sede sede);
    Sede updateSede(Long id, Sede sede);
    List<Sede> getAllSedes();
    Sede getSedeById(Long id);
    void deleteSede(Long id);
}
