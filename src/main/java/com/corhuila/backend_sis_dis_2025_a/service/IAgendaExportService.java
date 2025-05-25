package com.corhuila.backend_sis_dis_2025_a.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public interface IAgendaExportService {

    ByteArrayInputStream exportarAgendaProfesor(Long profesorId) throws IOException;
    
}
