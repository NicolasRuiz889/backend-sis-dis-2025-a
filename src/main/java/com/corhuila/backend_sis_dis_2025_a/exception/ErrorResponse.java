package com.corhuila.backend_sis_dis_2025_a.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public ErrorResponse(String resourceName, String fieldName, Object fieldValue) {
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
