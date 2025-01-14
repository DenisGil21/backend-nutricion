package com.nutricion.nutricion.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.nutricion.nutricion.dtos.AlimentoDTO;
import com.nutricion.nutricion.dtos.CustomPageDTO;
import com.nutricion.nutricion.entities.Alimento;

public class AlimentoMapper {
    private static final ModelMapper MAPPER = new ModelMapper();

    private AlimentoMapper() {
        throw new IllegalStateException("No existe un constructor para la clase");
    }

     public static Alimento mapAlimento(AlimentoDTO alimentoDTO) {
        return MAPPER.map(alimentoDTO, Alimento.class);
    }

    public static AlimentoDTO mapAlimentoDTO(Alimento alimento) {
        return MAPPER.map(alimento, AlimentoDTO.class);
    }

    public static CustomPageDTO<AlimentoDTO> convertToDtoPage(Page<Alimento> alimentos) {
        List<AlimentoDTO> alimentosDTO = alimentos.stream()
                .map(alimento -> MAPPER.map(alimento, AlimentoDTO.class))
                .collect(Collectors.toList());
        Page<AlimentoDTO> alimentoDTOPage = new PageImpl<>(alimentosDTO, alimentos.getPageable(), alimentos.getTotalElements());
        return new CustomPageDTO<>(alimentoDTOPage);
    }
}
