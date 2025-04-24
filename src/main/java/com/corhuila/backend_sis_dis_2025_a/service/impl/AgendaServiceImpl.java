package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.AgendaDto;
import com.corhuila.backend_sis_dis_2025_a.entity.*;
import com.corhuila.backend_sis_dis_2025_a.repository.*;
import com.corhuila.backend_sis_dis_2025_a.service.IAgendaService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AgendaServiceImpl implements IAgendaService {

    private final AgendaRepository repo;
    //private final PersonRepository personRepo;
    private final ActivityRepository actRepo;
    //private final ScheduleRepository ScheduleRepo;

    private AgendaDto toDto(Agenda e) {
        return AgendaDto.builder()
                .id(e.getId())
        //        .personId(e.getPerson().getId())
                .activityId(e.getActivity().getId())
        //        .ScheduleId(e.getSchedule().getId())
                .build();
    }

    private Agenda toEntity(AgendaDto d) {
        return Agenda.builder()
                .id(d.getId())
                //.Person(personRepo.findById(d.getPersonId())
                        //.orElseThrow(() -> new RuntimeException("Persona not found")))
                .activity(actRepo.findById(d.getActivityId())
                        .orElseThrow(() -> new RuntimeException("Activity not found")))
                //.schedule(ScheduleRepo.findById(d.getScheduleId())
                //        .orElseThrow(() -> new RuntimeException("Horario not found")))
                .build();
    }

    @Override public AgendaDto create(AgendaDto dto) {
        return toDto(repo.save(toEntity(dto)));
    }
    @Override public AgendaDto update(Long id, AgendaDto dto) {
        Agenda e = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Agenda not found"));
        //e.setPerson(personRepo.findById(dto.getPersonId())
        //        .orElseThrow(() -> new RuntimeException("Persona not found")));
        e.setActivity(actRepo.findById(dto.getActivityId())
                .orElseThrow(() -> new RuntimeException("Activity not found")));
        //e.setSchedule(ScheduleRepo.findById(dto.getScheduleId())
        //        .orElseThrow(() -> new RuntimeException("Horario not found")));
        return toDto(repo.save(e));
    }
    @Override public void delete(Long id) { repo.deleteById(id); }
    @Override public AgendaDto findById(Long id) {
        return repo.findById(id).map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Agenda not found"));
    }
    @Override public List<AgendaDto> findAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
