package com.nutricion.nutricion.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponseDTO<T> {
    private int status;
    private String mensaje;
    private T data;
}
