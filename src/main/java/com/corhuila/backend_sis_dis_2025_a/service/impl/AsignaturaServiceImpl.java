package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.request.AsignaturaRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.AsignaturaResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.Asignatura;
import com.corhuila.backend_sis_dis_2025_a.entity.Programa;
import com.corhuila.backend_sis_dis_2025_a.exception.ResourceNotFoundException;
import com.corhuila.backend_sis_dis_2025_a.repository.AsignaturaRepository;
import com.corhuila.backend_sis_dis_2025_a.service.IAsignaturaService;
import com.corhuila.backend_sis_dis_2025_a.service.IProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsignaturaServiceImpl implements IAsignaturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Autowired
    private IProgramaService programaService;

    @Override
    public AsignaturaResponseDTO saveAsignatura(AsignaturaRequestDTO dto) {
        Programa programa = programaService.getProgramaByIdEntity(dto.getProgramaId());

        Asignatura asignatura = new Asignatura();
        asignatura.setNombreAsignatura(dto.getNombreAsignatura());
        asignatura.setHoraSemanal(dto.getHoraSemanal());
        asignatura.setHoraSemestre(dto.getHoraSemestre());
        asignatura.setPrograma(programa);

        return mapToResponse(asignaturaRepository.save(asignatura));
    }

    @Override
    public AsignaturaResponseDTO updateAsignatura(Long id, AsignaturaRequestDTO dto) {
        Asignatura asignatura = getAsignaturaByIdEntity(id);
        Programa programa = programaService.getProgramaByIdEntity(dto.getProgramaId());

        asignatura.setNombreAsignatura(dto.getNombreAsignatura());
        asignatura.setHoraSemanal(dto.getHoraSemanal());
        asignatura.setHoraSemestre(dto.getHoraSemestre());
        asignatura.setPrograma(programa);

        return mapToResponse(asignaturaRepository.save(asignatura));
    }

    @Override
    public List<AsignaturaResponseDTO> getAllAsignaturas() {
        return asignaturaRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AsignaturaResponseDTO getAsignaturaById(Long id) {
        return mapToResponse(getAsignaturaByIdEntity(id));
    }

    @Override
    public void deleteAsignatura(Long id) {
        asignaturaRepository.delete(getAsignaturaByIdEntity(id));
    }

    public Asignatura getAsignaturaByIdEntity(Long id) {
        return asignaturaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asignatura", "id", id));
    }

    private AsignaturaResponseDTO mapToResponse(Asignatura asignatura) {
        AsignaturaResponseDTO dto = new AsignaturaResponseDTO();
        dto.setIdAsignatura(asignatura.getIdAsignatura());
        dto.setNombreAsignatura(asignatura.getNombreAsignatura());
        dto.setHoraSemanal(asignatura.getHoraSemanal());
        dto.setHoraSemestre(asignatura.getHoraSemestre());
        dto.setProgramaNombre(asignatura.getPrograma() != null ? asignatura.getPrograma().getNombrePrograma() : null);
        return dto;
    }

}
