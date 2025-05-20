package com.corhuila.backend_sis_dis_2025_a.service;

import com.corhuila.backend_sis_dis_2025_a.dto.request.PersonaRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.PersonaResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.Persona;

import java.util.List;

public interface IPersonaService {
    PersonaResponseDTO savePersona(PersonaRequestDTO dto);
    PersonaResponseDTO updatePersona(Long id, PersonaRequestDTO dto);
    List<PersonaResponseDTO> getAllPersonas();
    PersonaResponseDTO getPersonaById(Long id);
    void deletePersona(Long id);
    Persona getPersonaByIdEntity(Long id);
}
