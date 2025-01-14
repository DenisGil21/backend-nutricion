package com.nutricion.nutricion.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nutricion.nutricion.dtos.AlimentoDTO;
import com.nutricion.nutricion.dtos.CustomPageDTO;
import com.nutricion.nutricion.entities.Alimento;
import com.nutricion.nutricion.mappers.AlimentoMapper;
import com.nutricion.nutricion.repositories.AlimentoRepository;
import com.nutricion.nutricion.services.AlimentoService;

@Service
public class AlimentoServiceImpl implements AlimentoService{
    
    @Autowired
    private AlimentoRepository alimentoRepository;

     public CustomPageDTO<AlimentoDTO> getAlimentos(int page) {
        Pageable pagination = PageRequest.of(page - 1, 5);

        Page<Alimento> alimentos = alimentoRepository.findByOrderByIdAsc(pagination);

        return AlimentoMapper.convertToDtoPage(alimentos);
    }


    public List<AlimentoDTO> getAlimentosByGrupos(Long grupoId){
        List<Alimento> alimentos = alimentoRepository.findByGrupoId(grupoId);
        List<AlimentoDTO> alimentosDTO = new ArrayList<>();
        alimentos.forEach(alimento -> alimentosDTO.add(AlimentoMapper.mapAlimentoDTO(alimento)));

        return alimentosDTO;
    }
}
