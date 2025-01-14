package com.nutricion.nutricion.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GrupoDTO {
    private Long id;

    private String nombre;

    private int caloriasPorciones;

    private int proteina;

    private int grasa;

    private float carbohidrato;
    
    private int cont_carbo;
}
