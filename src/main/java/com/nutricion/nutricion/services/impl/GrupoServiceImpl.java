package com.nutricion.nutricion.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutricion.nutricion.dtos.GrupoDTO;
import com.nutricion.nutricion.entities.Grupo;
import com.nutricion.nutricion.mappers.GrupoMapper;
import com.nutricion.nutricion.repositories.GrupoRepository;
import com.nutricion.nutricion.services.GrupoService;

@Service
public class GrupoServiceImpl implements GrupoService {
    
    @Autowired
    private GrupoRepository grupoRepository;


    public List<GrupoDTO> getGrupos(){
        List<Grupo> grupos = grupoRepository.findAll();
        List<GrupoDTO> gruposDTO = new ArrayList<>();

        grupos.forEach(grupo -> gruposDTO.add(GrupoMapper.mapGrupoDTO(grupo)));

        return gruposDTO;
    }

    
}
