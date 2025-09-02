package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.request.ProgramaRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.ProgramaResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.Facultad;
import com.corhuila.backend_sis_dis_2025_a.entity.Programa;
import com.corhuila.backend_sis_dis_2025_a.exception.ResourceNotFoundException;
import com.corhuila.backend_sis_dis_2025_a.repository.ProgramaRepository;
import com.corhuila.backend_sis_dis_2025_a.service.IFacultadService;
import com.corhuila.backend_sis_dis_2025_a.service.IProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgramaServiceImpl implements IProgramaService {

    @Autowired
    private ProgramaRepository programaRepository;

    @Autowired
    private IFacultadService facultadService;

    @Override
    public ProgramaResponseDTO savePrograma(ProgramaRequestDTO dto) {
        Facultad facultad = facultadService.getFacultadByIdEntity(dto.getFacultadId());

        Programa programa = new Programa();
        programa.setNombrePrograma(dto.getNombrePrograma());
        programa.setFacultad(facultad);

        return mapToResponse(programaRepository.save(programa));
    }

    @Override
    public ProgramaResponseDTO updatePrograma(Long id, ProgramaRequestDTO dto) {
        Programa existing = getProgramaByIdEntity(id);
        Facultad facultad = facultadService.getFacultadByIdEntity(dto.getFacultadId());

        existing.setNombrePrograma(dto.getNombrePrograma());
        existing.setFacultad(facultad);

        return mapToResponse(programaRepository.save(existing));
    }

    @Override
    public List<ProgramaResponseDTO> getAllProgramas() {
        return programaRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProgramaResponseDTO getProgramaById(Long id) {
        return mapToResponse(getProgramaByIdEntity(id));
    }

    @Override
    public void deletePrograma(Long id) {
        programaRepository.delete(getProgramaByIdEntity(id));
    }

    public Programa getProgramaByIdEntity(Long id) {
        return programaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Programa", "id", id));
    }

    private ProgramaResponseDTO mapToResponse(Programa programa) {
        ProgramaResponseDTO dto = new ProgramaResponseDTO();
        dto.setIdPrograma(programa.getIdPrograma());
        dto.setNombrePrograma(programa.getNombrePrograma());
        dto.setFacultadNombre(programa.getFacultad() != null ? programa.getFacultad().getNombreFacultad() : null);
        return dto;
    }

}
