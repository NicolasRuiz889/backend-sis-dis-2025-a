package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.entity.Persona;
import com.corhuila.backend_sis_dis_2025_a.entity.TipoVinculacion;
import com.corhuila.backend_sis_dis_2025_a.exception.ResourceNotFoundException;
import com.corhuila.backend_sis_dis_2025_a.repository.PersonaRepository;
import com.corhuila.backend_sis_dis_2025_a.service.IPersonaService;
import com.corhuila.backend_sis_dis_2025_a.service.IRolesService;
import com.corhuila.backend_sis_dis_2025_a.service.ITipoVinculacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private ITipoVinculacionService tipoVinculacionService;

    @Autowired
    private IRolesService rolesService;

    @Override
    public Persona savePersona(Persona persona) {
        if (persona.getNombre() == null || persona.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la persona es obligatorio.");
        }

        TipoVinculacion tipoVinculacion = tipoVinculacionService.getTipoVinculacionById(persona.getTipoVinculacion().getIdVinculacion());
        persona.setTipoVinculacion(tipoVinculacion);

        return personaRepository.save(persona);
    }

    @Override
    public Persona updatePersona(Long id, Persona persona) {
        Persona existingPersona = getPersonaById(id);

        existingPersona.setNombre(persona.getNombre());
        existingPersona.setApellido(persona.getApellido());
        existingPersona.setFechaFirma(persona.getFechaFirma());
        existingPersona.setFirmaDigital(persona.getFirmaDigital());
        existingPersona.setEstadoFirma(persona.getEstadoFirma());

        if (persona.getTipoVinculacion() != null) {
            TipoVinculacion tipoVinculacion = tipoVinculacionService.getTipoVinculacionById(persona.getTipoVinculacion().getIdVinculacion());
            existingPersona.setTipoVinculacion(tipoVinculacion);
        }
        return personaRepository.save(existingPersona);
    }

    @Override
    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public Persona getPersonaById(Long id) {
        return personaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Persona", "id", id));
    }

    @Override
    public void deletePersona(Long id) {
        Persona persona = getPersonaById(id);
        personaRepository.delete(persona);
    }

}
