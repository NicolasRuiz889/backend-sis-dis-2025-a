package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.request.AgendaRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.AgendaResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.Actividad;
import com.corhuila.backend_sis_dis_2025_a.entity.Agenda;
import com.corhuila.backend_sis_dis_2025_a.entity.Horario;
import com.corhuila.backend_sis_dis_2025_a.entity.Persona;
import com.corhuila.backend_sis_dis_2025_a.exception.ResourceNotFoundException;
import com.corhuila.backend_sis_dis_2025_a.repository.AgendaRepository;
import com.corhuila.backend_sis_dis_2025_a.service.IActividadService;
import com.corhuila.backend_sis_dis_2025_a.service.IAgendaService;
import com.corhuila.backend_sis_dis_2025_a.service.IHorarioService;
import com.corhuila.backend_sis_dis_2025_a.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendaServiceImpl implements IAgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IActividadService actividadService;

    @Autowired
    private IHorarioService horarioService;

    @Override
    public AgendaResponseDTO save(AgendaRequestDTO dto) {
        Persona persona = personaService.getPersonaByIdEntity(dto.getPersonaId());
        Actividad actividad = actividadService.getByIdEntity(dto.getActividadId());
        Horario horario = horarioService.getHorarioByIdEntity(dto.getHorarioId());

        Agenda agenda = new Agenda();
        agenda.setPersona(persona);
        agenda.setActividad(actividad);
        agenda.setHorario(horario);

        return mapToResponse(agendaRepository.save(agenda));
    }

    @Override
    public AgendaResponseDTO update(Long id, AgendaRequestDTO dto) {
        Agenda agenda = getByIdEntity(id);
        agenda.setPersona(personaService.getPersonaByIdEntity(dto.getPersonaId()));
        agenda.setActividad(actividadService.getByIdEntity(dto.getActividadId()));
        agenda.setHorario(horarioService.getHorarioByIdEntity(dto.getHorarioId()));

        return mapToResponse(agendaRepository.save(agenda));
    }

    @Override
    public List<AgendaResponseDTO> getAll() {
        return agendaRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AgendaResponseDTO getById(Long id) {
        return mapToResponse(getByIdEntity(id));
    }

    @Override
    public void delete(Long id) {
        agendaRepository.delete(getByIdEntity(id));
    }

    private Agenda getByIdEntity(Long id) {
        return agendaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agenda", "id", id));
    }

    private AgendaResponseDTO mapToResponse(Agenda agenda) {
        AgendaResponseDTO dto = new AgendaResponseDTO();
        dto.setIdAgenda(agenda.getIdAgenda());
        dto.setPersonaNombre(agenda.getPersona().getNombre() + " " + agenda.getPersona().getApellido());
        dto.setActividadNombre(agenda.getActividad().getNombreActividad());
        dto.setHorarioResumen(agenda.getHorario() != null ? agenda.getHorario().toString() : null);
        return dto;
    }

}
