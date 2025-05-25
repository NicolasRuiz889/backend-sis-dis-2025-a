package com.corhuila.backend_sis_dis_2025_a.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corhuila.backend_sis_dis_2025_a.service.IAgendaExportService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/export")
public class AgendaExportController {

    private final IAgendaExportService agendaExportService;

    public AgendaExportController(IAgendaExportService agendaExportService) {
        this.agendaExportService = agendaExportService;
    }

    @GetMapping("/agenda-profesor/{profesorId}")
    public ResponseEntity<InputStreamResource> exportarAgenda(@PathVariable Long profesorId) throws IOException {
        ByteArrayInputStream stream = agendaExportService.exportarAgendaProfesor(profesorId);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=agenda_profesor.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(new InputStreamResource(stream));
    }
    
}
