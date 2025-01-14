package com.nutricion.nutricion.mappers;

import org.modelmapper.ModelMapper;

import com.nutricion.nutricion.dtos.TiempoDTO;
import com.nutricion.nutricion.entities.Tiempo;

public class TiempoMapper {

    private static final ModelMapper MAPPER = new ModelMapper();


    private TiempoMapper() {
        throw new IllegalStateException("No existe un constructor para la clase");
    }

     public static Tiempo mapTiempo(TiempoDTO tiempoDTO) {
        return MAPPER.map(tiempoDTO, Tiempo.class);
    }

    public static TiempoDTO mapTiempoDTO(Tiempo tiempo) {
        return MAPPER.map(tiempo, TiempoDTO.class);
    }
}
