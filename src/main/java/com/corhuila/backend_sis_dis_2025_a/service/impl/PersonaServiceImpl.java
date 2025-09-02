package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.request.PersonaRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.PersonaResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.Persona;
import com.corhuila.backend_sis_dis_2025_a.entity.Roles;
import com.corhuila.backend_sis_dis_2025_a.entity.TipoVinculacion;
import com.corhuila.backend_sis_dis_2025_a.exception.ResourceNotFoundException;
import com.corhuila.backend_sis_dis_2025_a.repository.PersonaRepository;
import com.corhuila.backend_sis_dis_2025_a.service.IPersonaService;
import com.corhuila.backend_sis_dis_2025_a.service.IRolesService;
import com.corhuila.backend_sis_dis_2025_a.service.ITipoVinculacionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private ITipoVinculacionService tipoVinculacionService;

    @Autowired
    private IRolesService rolesService;

    @Override
    public PersonaResponseDTO savePersona(PersonaRequestDTO dto) {
        TipoVinculacion tipo = tipoVinculacionService.getTipoVinculacionByIdEntity(dto.getTipoVinculacionId());
        Set<Roles> roles = rolesService.getRolesByIds(dto.getRolesIds());

        Persona persona = new Persona();
        persona.setNombre(dto.getNombre());
        persona.setApellido(dto.getApellido());
        persona.setFechaFirma(dto.getFechaFirma());
        persona.setFirmaDigital(dto.getFirmaDigital());
        persona.setEstadoFirma(dto.getEstadoFirma());
        persona.setTipoVinculacion(tipo);
        persona.setRoles(roles);

        return mapToResponse(personaRepository.save(persona));
    }

    @Override
    public PersonaResponseDTO updatePersona(Long id, PersonaRequestDTO dto) {
        Persona existing = getPersonaByIdEntity(id);

        existing.setNombre(dto.getNombre());
        existing.setApellido(dto.getApellido());
        existing.setFechaFirma(dto.getFechaFirma());
        existing.setFirmaDigital(dto.getFirmaDigital());
        existing.setEstadoFirma(dto.getEstadoFirma());

        if (dto.getTipoVinculacionId() != null) {
            TipoVinculacion tipo = tipoVinculacionService.getTipoVinculacionByIdEntity(dto.getTipoVinculacionId());
            existing.setTipoVinculacion(tipo);
        }

        if (dto.getRolesIds() != null && !dto.getRolesIds().isEmpty()) {
            Set<Roles> roles = rolesService.getRolesByIds(dto.getRolesIds());
            existing.setRoles(roles);
        }

        return mapToResponse(personaRepository.save(existing));
    }

    @Override
    @Transactional
    public List<PersonaResponseDTO> getAllPersonas() {
        return personaRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PersonaResponseDTO getPersonaById(Long id) {
        return mapToResponse(getPersonaByIdEntity(id));
    }

    @Override
    public void deletePersona(Long id) {
        personaRepository.delete(getPersonaByIdEntity(id));
    }

    public Persona getPersonaByIdEntity(Long id) {
        return personaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Persona", "id", id));
    }

    private PersonaResponseDTO mapToResponse(Persona persona) {
        PersonaResponseDTO dto = new PersonaResponseDTO();
        dto.setIdPersona(persona.getIdPersona());
        dto.setNombre(persona.getNombre());
        dto.setApellido(persona.getApellido());
        dto.setFechaFirma(persona.getFechaFirma());
        dto.setFirmaDigital(persona.getFirmaDigital());
        dto.setEstadoFirma(persona.getEstadoFirma());
        dto.setTipoVinculacionNombre(persona.getTipoVinculacion() != null ? persona.getTipoVinculacion().getNombreVinculacion() : null);
        dto.setRolesNombres(
                persona.getRoles() != null
                        ? persona.getRoles().stream().map(Roles::getNombreRol).collect(Collectors.toSet())
                        : Collections.emptySet()
        );
        return dto;
    }

}
