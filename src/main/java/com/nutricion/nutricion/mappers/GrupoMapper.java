package com.nutricion.nutricion.mappers;

import org.modelmapper.ModelMapper;

import com.nutricion.nutricion.dtos.GrupoDTO;
import com.nutricion.nutricion.entities.Grupo;

public class GrupoMapper {
    private static final ModelMapper MAPPER = new ModelMapper();

    private GrupoMapper() {
        throw new IllegalStateException("No existe un constructor para la clase");
    }

     public static Grupo mapGrupo(GrupoDTO grupoDTO) {
        return MAPPER.map(grupoDTO, Grupo.class);
    }

    public static GrupoDTO mapGrupoDTO(Grupo grupo) {
        return MAPPER.map(grupo, GrupoDTO.class);
    }
}
