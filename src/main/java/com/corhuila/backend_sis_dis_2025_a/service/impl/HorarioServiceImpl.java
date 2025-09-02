package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.request.HorarioRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.HorarioResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.Grupo;
import com.corhuila.backend_sis_dis_2025_a.entity.Horario;
import com.corhuila.backend_sis_dis_2025_a.exception.ResourceNotFoundException;
import com.corhuila.backend_sis_dis_2025_a.repository.HorarioRepository;
import com.corhuila.backend_sis_dis_2025_a.service.IGrupoService;
import com.corhuila.backend_sis_dis_2025_a.service.IHorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HorarioServiceImpl implements IHorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    @Autowired
    private IGrupoService grupoService;

    @Override
    public HorarioResponseDTO save(HorarioRequestDTO dto) {
        Grupo grupo = grupoService.getGrupoByIdEntity(dto.getGrupoId());

        Horario horario = new Horario();
        horario.setDiaSemana(dto.getDiaSemana());
        horario.setHoraInicio(dto.getHoraInicio());
        horario.setHoraFin(dto.getHoraFin());
        horario.setGrupo(grupo);

        return mapToResponse(horarioRepository.save(horario));
    }

    @Override
    public HorarioResponseDTO update(Long id, HorarioRequestDTO dto) {
        Horario horario = getHorarioByIdEntity(id);
        Grupo grupo = grupoService.getGrupoByIdEntity(dto.getGrupoId());

        horario.setDiaSemana(dto.getDiaSemana());
        horario.setHoraInicio(dto.getHoraInicio());
        horario.setHoraFin(dto.getHoraFin());
        horario.setGrupo(grupo);

        return mapToResponse(horarioRepository.save(horario));
    }

    @Override
    public List<HorarioResponseDTO> getAll() {
        return horarioRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public HorarioResponseDTO getById(Long id) {
        return mapToResponse(getHorarioByIdEntity(id));
    }

    @Override
    public void delete(Long id) {
        horarioRepository.delete(getHorarioByIdEntity(id));
    }

    @Override
    public Horario getHorarioByIdEntity(Long id) {
        return horarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Horario", "id", id));
    }

    private HorarioResponseDTO mapToResponse(Horario horario) {
        HorarioResponseDTO dto = new HorarioResponseDTO();
        dto.setIdHorario(horario.getIdHorario());
        dto.setDiaSemana(horario.getDiaSemana());
        dto.setHoraInicio(horario.getHoraInicio());
        dto.setHoraFin(horario.getHoraFin());
        dto.setGrupoNombre(horario.getGrupo() != null ? horario.getGrupo().getNumeroGrupo() : null);
        return dto;
    }
}
