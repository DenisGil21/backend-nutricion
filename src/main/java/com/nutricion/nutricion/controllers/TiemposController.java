package com.nutricion.nutricion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.nutricion.nutricion.dtos.ApiResponseDTO;
import com.nutricion.nutricion.dtos.TiempoDTO;
import com.nutricion.nutricion.services.TiempoService;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TiemposController {

    @Autowired
    private TiempoService tiempoService;

    @GetMapping("tiempos")
    public ResponseEntity<ApiResponseDTO<List<TiempoDTO>>> getTiempos() {
        return ResponseEntity.ok(new ApiResponseDTO<>(200, "SUCCESS", tiempoService.getTiempos()));
    }
    

}
