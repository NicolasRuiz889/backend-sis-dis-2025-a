package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.request.SedeRequestDTO;
import com.corhuila.backend_sis_dis_2025_a.dto.response.SedeResponseDTO;
import com.corhuila.backend_sis_dis_2025_a.entity.Facultad;
import com.corhuila.backend_sis_dis_2025_a.entity.Sede;
import com.corhuila.backend_sis_dis_2025_a.exception.ResourceNotFoundException;
import com.corhuila.backend_sis_dis_2025_a.repository.SedeRepository;
import com.corhuila.backend_sis_dis_2025_a.service.ISedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SedeServiceImpl implements ISedeService {

    @Autowired
    private SedeRepository sedeRepository;

    @Override
    public SedeResponseDTO saveSede(SedeRequestDTO sedeDTO) {
        if (sedeDTO.getNombreSede() == null || sedeDTO.getNombreSede().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la sede es obligatorio.");
        }

        Sede sede = mapToEntity(sedeDTO);
        Sede saved = sedeRepository.save(sede);
        return mapToResponse(saved);
    }

    @Override
    public SedeResponseDTO updateSede(Long id, SedeRequestDTO sedeDTO) {
        Sede existing = getSedeByIdEntity(id);
        existing.setNombreSede(sedeDTO.getNombreSede());
        Sede updated = sedeRepository.save(existing);
        return mapToResponse(updated);
    }

    @Override
    public List<SedeResponseDTO> getAllSedes() {
        return sedeRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public SedeResponseDTO getSedeById(Long id) {
        return mapToResponse(getSedeByIdEntity(id));
    }

    @Override
    public void deleteSede(Long id) {
        Sede sede = getSedeByIdEntity(id);
        sedeRepository.delete(sede);
    }

    public Sede getSedeByIdEntity(Long id) {
        return sedeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sede", "id", id));
    }

    private Sede mapToEntity(SedeRequestDTO dto) {
        Sede sede = new Sede();
        sede.setNombreSede(dto.getNombreSede());
        return sede;
    }

    private SedeResponseDTO mapToResponse(Sede sede) {
        SedeResponseDTO dto = new SedeResponseDTO();
        dto.setIdSede(sede.getIdSede());
        dto.setNombreSede(sede.getNombreSede());
        if (sede.getFacultades() != null) {
            dto.setFacultades(sede.getFacultades()
                    .stream()
                    .map(Facultad::getNombreFacultad)
                    .collect(Collectors.toList()));
        }
        return dto;
    }
}
