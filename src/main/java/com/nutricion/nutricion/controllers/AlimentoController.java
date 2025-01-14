package com.nutricion.nutricion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nutricion.nutricion.dtos.AlimentoDTO;
import com.nutricion.nutricion.dtos.ApiResponseDTO;
import com.nutricion.nutricion.dtos.CustomPageDTO;
import com.nutricion.nutricion.services.AlimentoService;

@RestController
public class AlimentoController {

    @Autowired
    private AlimentoService alimentoService;

    @GetMapping("alimentos")
    public ResponseEntity<ApiResponseDTO<CustomPageDTO<AlimentoDTO>>> getUsers(@RequestParam(value = "page", defaultValue = "1") int page) {
        return ResponseEntity.ok(new ApiResponseDTO<>(200, "SUCCESS", alimentoService.getAlimentos(page)));
    }

}
