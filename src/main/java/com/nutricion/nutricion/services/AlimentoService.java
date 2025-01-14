package com.nutricion.nutricion.services;

import java.util.List;

import com.nutricion.nutricion.dtos.AlimentoDTO;
import com.nutricion.nutricion.dtos.CustomPageDTO;

public interface AlimentoService {
    public CustomPageDTO<AlimentoDTO>getAlimentos(int page);
    public List<AlimentoDTO> getAlimentosByGrupos(Long id);

}
