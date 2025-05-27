package com.corhuila.backend_sis_dis_2025_a.service.impl;

import java.io.ByteArrayOutputStream;

import com.corhuila.backend_sis_dis_2025_a.dto.response.ActivityResponse;
import com.corhuila.backend_sis_dis_2025_a.dto.response.ClassOrientationResponse;
import com.corhuila.backend_sis_dis_2025_a.dto.response.ProductResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


import com.corhuila.backend_sis_dis_2025_a.service.IActivityService;
import com.corhuila.backend_sis_dis_2025_a.service.IAgendaExportService;
import com.corhuila.backend_sis_dis_2025_a.service.IClassOrientationService;

@Service
public class AgendaExportServiceImpl implements IAgendaExportService {

    private final IClassOrientationService classOrientationService;
    private final IActivityService activityService;

    public AgendaExportServiceImpl(IClassOrientationService classOrientationService,
            IActivityService activityService) {
        this.classOrientationService = classOrientationService;
        this.activityService = activityService;
    }

    @Override
    public ByteArrayInputStream exportarAgendaProfesor(Long profesorId) throws IOException {
        List<ClassOrientationResponse> orientaciones = classOrientationService.findByProfesorId(profesorId);
        List<ActivityResponse> activities = activityService.findByProfesorId(profesorId);

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Agenda Profesor");
            int rowNum = 0;

            // ===== ESTILOS =====
            CellStyle tituloStyle = workbook.createCellStyle();
            Font tituloFont = workbook.createFont();
            tituloFont.setBold(true);
            tituloFont.setFontHeightInPoints((short) 14);
            tituloStyle.setFont(tituloFont);
            tituloStyle.setAlignment(HorizontalAlignment.CENTER);
            tituloStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            tituloStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle infoStyle = workbook.createCellStyle();
            infoStyle.setAlignment(HorizontalAlignment.LEFT);

            CellStyle headerStyle = workbook.createCellStyle();
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerStyle.setFont(headerFont);
            headerStyle.setAlignment(HorizontalAlignment.CENTER);
            headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderTop(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);

            CellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setBorderBottom(BorderStyle.THIN);
            cellStyle.setBorderTop(BorderStyle.THIN);
            cellStyle.setBorderLeft(BorderStyle.THIN);
            cellStyle.setBorderRight(BorderStyle.THIN);
            cellStyle.setWrapText(true);

            // ===== 1. TÍTULO =====
            Row tituloRow = sheet.createRow(rowNum++);
            Cell tituloCell = tituloRow.createCell(0);
            tituloCell.setCellValue("AGENDA SEMESTRAL PROFESORAL");
            tituloCell.setCellStyle(tituloStyle);
            sheet.addMergedRegion(new CellRangeAddress(rowNum - 1, rowNum - 1, 0, 5));

            // ===== 2. DATOS DEL PROFESOR =====
            Row infoRow = sheet.createRow(rowNum++);
            infoRow.createCell(0).setCellValue("Profesor:");
            infoRow.createCell(1).setCellValue("profesor.getNombre()");
            infoRow.createCell(3).setCellValue("Facultad:");
            infoRow.createCell(4).setCellValue("profesor.getFaculty()");
            rowNum++;

            // Ajustar ancho total para secciones superiores (Título y Datos del Profesor)
            int columnasTotales = 5; 
            for (int i = 0; i < columnasTotales; i++) {
            sheet.setColumnWidth(i, 3000); 
            }

            // ===== 3. DOCENCIA =====
            if (!orientaciones.isEmpty()) {
                Row docenciaTitleRow = sheet.createRow(rowNum++);
                Cell docenciaTitleCell = docenciaTitleRow.createCell(0);
                docenciaTitleCell.setCellValue("LABORES DE DOCENCIA, ACADÉMICAS Y FORMATIVAS");
                docenciaTitleCell.setCellStyle(tituloStyle);
                sheet.addMergedRegion(
                        new CellRangeAddress(docenciaTitleRow.getRowNum(), docenciaTitleRow.getRowNum(), 0, 5));

                Row subTitleRow = sheet.createRow(rowNum++);
                Cell subTitleCell = subTitleRow.createCell(0);
                subTitleCell.setCellValue("DOCENCIA");
                subTitleCell.setCellStyle(headerStyle);
                sheet.addMergedRegion(new CellRangeAddress(subTitleRow.getRowNum(), subTitleRow.getRowNum(), 0, 5));

                int anchoTotalO = 30000;
                Row headerRow = sheet.createRow(rowNum++);
                String[] headers = { "ASIGNATURA", "PROGRAMA", "GRUPO", "SEDE", "HORAS SEMANALES", "HORAS SEMESTRE" };
                for (int i = 0; i < headers.length; i++) {
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(headers[i]);
                    cell.setCellStyle(headerStyle);
                }

                // 1. Inicializa acumuladores
                int totalHorasSemanales = 0;
                int totalHorasSemestre = 0;
                for (ClassOrientationResponse o : orientaciones) {
                    Row row = sheet.createRow(rowNum++);
                    row.createCell(0).setCellValue(o.getSubjectName());
                    row.createCell(1).setCellValue(o.getProgramName());
                    row.createCell(2).setCellValue(o.getGroupName());
                    row.createCell(3).setCellValue(o.getCampusName());
                    row.createCell(4).setCellValue(o.getWeeklyHours());
                    row.createCell(5).setCellValue(o.getSemesterHours());

                    // 2. Acumula horas
                    totalHorasSemanales += o.getWeeklyHours();
                    totalHorasSemestre += o.getSemesterHours();

                }

                // 3. Fila de totales
                Row totalRow = sheet.createRow(rowNum++);
                Cell totalLabelCell = totalRow.createCell(0);
                totalLabelCell.setCellValue("TOTALES:");
                totalLabelCell.setCellStyle(headerStyle); 
                sheet.addMergedRegion(new CellRangeAddress(totalRow.getRowNum(), totalRow.getRowNum(), 0, 3));

                Cell totalSemanalCell = totalRow.createCell(4);
                totalSemanalCell.setCellValue(totalHorasSemanales);
                totalSemanalCell.setCellStyle(headerStyle);

                Cell totalSemestreCell = totalRow.createCell(5);
                totalSemestreCell.setCellValue(totalHorasSemestre);
                totalSemestreCell.setCellStyle(headerStyle);

                // Ajustar ancho columnas orientación de clases
                int columnasOrientacion = 6;
                int anchoColumnaOrientacion = anchoTotalO / columnasOrientacion;
                for (int i = 0; i < columnasOrientacion; i++) {
                    sheet.setColumnWidth(i, anchoColumnaOrientacion);
                }

                rowNum++;
            }
            // ===== ESTILOS EXTRA PARA AGRUPACIÓN =====
            CellStyle categoriaStyle = workbook.createCellStyle();
            Font categoriaFont = workbook.createFont();
            categoriaFont.setBold(true);
            categoriaFont.setColor(IndexedColors.WHITE.getIndex());
            categoriaFont.setFontHeightInPoints((short) 12);
            categoriaStyle.setFont(categoriaFont);
            categoriaStyle.setAlignment(HorizontalAlignment.CENTER);
            // Color personalizado en RGB (R, G, B)
            byte[] rgbTurquesa = new byte[] { 0, (byte) 217, (byte) 217 }; // #00D9D9
            categoriaStyle.setFillForegroundColor(new XSSFColor(rgbTurquesa, null));
            categoriaStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle subcategoriaStyle = workbook.createCellStyle();
            Font subcategoriaFont = workbook.createFont();
            subcategoriaFont.setBold(true);
            subcategoriaStyle.setFont(subcategoriaFont);
            subcategoriaStyle.setAlignment(HorizontalAlignment.CENTER);
            subcategoriaStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            subcategoriaStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            // ===== 4. ACTIVIDADES =====
            if (!activities.isEmpty()) {
                Row actividadesTitleRow = sheet.createRow(rowNum++);
                Cell actividadesTitleCell = actividadesTitleRow.createCell(0);
                actividadesTitleCell.setCellValue("ACTIVIDADES");
                actividadesTitleCell.setCellStyle(tituloStyle);
                sheet.addMergedRegion(
                        new CellRangeAddress(actividadesTitleRow.getRowNum(), actividadesTitleRow.getRowNum(), 0, 5));

                // Agrupar actividades por categoría y subcategoría
                Map<String, Map<String, List<ActivityResponse>>> groupedActivities = activities.stream()
                        .collect(Collectors.groupingBy(
                                ActivityResponse::getCategoryName,
                                LinkedHashMap::new,
                                Collectors.groupingBy(
                                        ActivityResponse::getSubcategoryName,
                                        LinkedHashMap::new,
                                        Collectors.toList())));

                for (Map.Entry<String, Map<String, List<ActivityResponse>>> categoriaEntry : groupedActivities.entrySet()) {
                    String categoria = categoriaEntry.getKey();
                    Map<String, List<ActivityResponse>> subcategorias = categoriaEntry.getValue();

                    int categoriaHorasSemana = 0;
                    int categoriaHorasSemestre = 0;

                    // Categoría con fondo celeste y celdas combinadas
                    Row categoriaRow = sheet.createRow(rowNum++);
                    Cell categoriaCell = categoriaRow.createCell(0);
                    categoriaCell.setCellValue(categoria.toUpperCase());
                    categoriaCell.setCellStyle(categoriaStyle);
                    sheet.addMergedRegion(
                            new CellRangeAddress(categoriaRow.getRowNum(), categoriaRow.getRowNum(), 0, 5));

                    for (Map.Entry<String, List<ActivityResponse>> subcategoriaEntry : subcategorias.entrySet()) {
                        String subcategoria = subcategoriaEntry.getKey();
                        List<ActivityResponse> actividades = subcategoriaEntry.getValue();


                        int subHorasSemana = actividades.stream()
                                .mapToInt(a -> a.getWeeklyHours() != null ? a.getWeeklyHours() : 0).sum();
                        int subHorasSemestre = actividades.stream()
                                .mapToInt(a -> a.getSemesterHours() != null ? a.getSemesterHours() : 0).sum();

                        categoriaHorasSemana += subHorasSemana;
                        categoriaHorasSemestre += subHorasSemestre;

                        // Subcategoría con fondo gris claro
                        Row subcategoriaRow = sheet.createRow(rowNum++);
                        Cell subcategoriaCell = subcategoriaRow.createCell(0);
                        subcategoriaCell.setCellValue(subcategoria);
                        subcategoriaCell.setCellStyle(subcategoriaStyle);
                        sheet.addMergedRegion(
                                new CellRangeAddress(subcategoriaRow.getRowNum(), subcategoriaRow.getRowNum(), 0, 5));

                        // Encabezado de tabla
                        Row headerRow = sheet.createRow(rowNum++);
                        String[] columnas = {
                                "ACTIVIDAD", "DEDICACIÓN (HORAS SEMANALES)", "DEDICACIÓN (HORAS SEMESTRE)",
                                "DESCRIPCIÓN DE LA ACTIVIDAD", "PRODUCTO"
                        };

                        for (int i = 0; i < columnas.length; i++) {
                            Cell cell = headerRow.createCell(i);
                            cell.setCellValue(columnas[i]);
                            cell.setCellStyle(headerStyle);
                        }

                        int anchoTotal = 30000;

                        int columnasActividadesCount = 5;
                        int anchoColumnaActividad = anchoTotal / columnasActividadesCount;
                        for (int i = 0; i < columnasActividadesCount; i++) {
                            sheet.setColumnWidth(i, anchoColumnaActividad);
                        }

                        // Actividades
                        for (ActivityResponse a : actividades) {
                            Row row = sheet.createRow(rowNum++);
                            createCell(row, 0, a.getActivityCatalogName(), cellStyle);
                            createCell(row, 1, a.getWeeklyHours(), cellStyle);
                            createCell(row, 2, a.getSemesterHours(), cellStyle);
                            createCell(row, 3, a.getDescription(), cellStyle);

                            String productos = a.getProducts() != null
                                    ? a.getProducts().stream().map(ProductResponse::getName).collect(Collectors.joining("\n"))
                                    : "";
                            createCell(row, 4, productos, cellStyle);
                        }

                    }

                    // Totales categoría
                    Row totalCatRow = sheet.createRow(rowNum++);
                    createCell(totalCatRow, 0, "Total :", boldFontStyle(workbook));
                    createCell(totalCatRow, 1, categoriaHorasSemana, cellStyle);
                    createCell(totalCatRow, 2, categoriaHorasSemestre, cellStyle);
                }

            }

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    // Utilidades para crear celdas con estilo
    private void createCell(Row row, int colIndex, String value, CellStyle style) {
        Cell cell = row.createCell(colIndex);
        cell.setCellValue(value != null ? value : "");
        cell.setCellStyle(style);
    }

    private void createCell(Row row, int colIndex, Integer value, CellStyle style) {
        Cell cell = row.createCell(colIndex);
        cell.setCellValue(value != null ? value : 0);
        cell.setCellStyle(style);
    }

    private CellStyle boldFontStyle(Workbook wb) {
        Font font = wb.createFont();
        font.setBold(true);
        CellStyle style = wb.createCellStyle();
        style.setFont(font);
        return style;
    }

}
