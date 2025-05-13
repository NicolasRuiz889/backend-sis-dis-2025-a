package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.entity.Persona;

import java.util.List;

public interface IPersonaService {
    Persona savePersona(Persona persona);
    Persona updatePersona(Long id, Persona persona);
    List<Persona> getAllPersonas();
    Persona getPersonaById(Long id);
    void deletePersona(Long id);
}
