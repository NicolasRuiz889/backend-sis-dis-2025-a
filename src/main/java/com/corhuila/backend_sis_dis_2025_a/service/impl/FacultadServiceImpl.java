package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.request.FacultadRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.FacultadResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.Facultad;
import com.corhuila.backend_sis_dis_2025_a.entity.Sede;
import com.corhuila.backend_sis_dis_2025_a.exception.ResourceNotFoundException;
import com.corhuila.backend_sis_dis_2025_a.repository.FacultadRepository;
import com.corhuila.backend_sis_dis_2025_a.service.IFacultadService;
import com.corhuila.backend_sis_dis_2025_a.service.ISedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultadServiceImpl implements IFacultadService {

    @Autowired
    private FacultadRepository facultadRepository;

    @Autowired
    private ISedeService sedeService;

    @Override
    public FacultadResponseDTO saveFacultad(FacultadRequestDTO dto) {
        Sede sede = sedeService.getSedeByIdEntity(dto.getSedeId());
        Facultad facultad = new Facultad();
        facultad.setNombreFacultad(dto.getNombreFacultad());
        facultad.setSede(sede);
        return mapToResponse(facultadRepository.save(facultad));
    }

    @Override
    public FacultadResponseDTO updateFacultad(Long id, FacultadRequestDTO dto) {
        Facultad existing = getFacultadByIdEntity(id);
        existing.setNombreFacultad(dto.getNombreFacultad());

        Sede sede = sedeService.getSedeByIdEntity(dto.getSedeId());
        existing.setSede(sede);

        return mapToResponse(facultadRepository.save(existing));
    }

    @Override
    public List<FacultadResponseDTO> getAllFacultades() {
        return facultadRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FacultadResponseDTO getFacultadById(Long id) {
        return mapToResponse(getFacultadByIdEntity(id));
    }

    @Override
    public void deleteFacultad(Long id) {
        facultadRepository.delete(getFacultadByIdEntity(id));
    }

    public Facultad getFacultadByIdEntity(Long id) {
        return facultadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Facultad", "id", id));
    }

    private FacultadResponseDTO mapToResponse(Facultad facultad) {
        FacultadResponseDTO dto = new FacultadResponseDTO();
        dto.setIdFacultad(facultad.getIdFacultad());
        dto.setNombreFacultad(facultad.getNombreFacultad());
        dto.setSedeNombre(facultad.getSede() != null ? facultad.getSede().getNombreSede() : null);
        return dto;
    }

}
