package com.nutricion.nutricion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nutricion.nutricion.dtos.AlimentoDTO;
import com.nutricion.nutricion.dtos.ApiResponseDTO;
import com.nutricion.nutricion.dtos.GrupoDTO;
import com.nutricion.nutricion.services.AlimentoService;
import com.nutricion.nutricion.services.GrupoService;

@Controller
public class GruposController {

    @Autowired
    private GrupoService grupoService;

    @Autowired
    private AlimentoService alimentoService;
    
    @GetMapping("grupos")
    public ResponseEntity<ApiResponseDTO<List<GrupoDTO>>> getGrupos() {
        return ResponseEntity.ok(new ApiResponseDTO<>(200, "SUCCESS", grupoService.getGrupos()));
    }

    @GetMapping("grupos/{id}/alimentos")
    public ResponseEntity<ApiResponseDTO<List<AlimentoDTO>>> getAlimentosByGrupos(@PathVariable Long id) {
        return ResponseEntity.ok(new ApiResponseDTO<>(200, "SUCCESS", alimentoService.getAlimentosByGrupos(id)));
    }

}
