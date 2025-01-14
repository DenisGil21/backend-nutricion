package com.nutricion.nutricion.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlimentoDTO {
    private Long id;

    private String nombre;

    private String porcion;

    private int gramos;
}
