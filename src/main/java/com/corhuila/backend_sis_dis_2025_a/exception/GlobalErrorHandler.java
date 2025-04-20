package com.corhuila.backend_sis_dis_2025_a.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.Map;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,Object>> handleAllExceptions(
            Exception ex, HttpServletRequest req) {
        Map<String,Object> body = Map.of(
                "timestamp", Instant.now(),
                "status",    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "error",     "Internal Server Error",
                "message",   ex.getMessage(),
                "path",      req.getRequestURI()
        );
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(body);
    }
}

