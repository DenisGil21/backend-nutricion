package com.nutricion.nutricion.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutricion.nutricion.dtos.TiempoDTO;
import com.nutricion.nutricion.mappers.TiempoMapper;
import com.nutricion.nutricion.repositories.TiempoRepository;
import com.nutricion.nutricion.services.TiempoService;

@Service
public class TiemposServiceImpl implements TiempoService{

    @Autowired
    private TiempoRepository tiempoRepository;

    public List<TiempoDTO> getTiempos(){
        List<TiempoDTO> tiemposDTO = new ArrayList<>();

        tiempoRepository.findAll().forEach(tiempo -> tiemposDTO.add(TiempoMapper.mapTiempoDTO(tiempo)));

        return tiemposDTO;
    }
}
