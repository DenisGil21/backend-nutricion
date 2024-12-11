package com.nutricion.nutricion.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.nutricion.nutricion.dtos.ApiResponseDTO;
import com.nutricion.nutricion.dtos.CustomPageDTO;
import com.nutricion.nutricion.dtos.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/")
public class UserController {
    @Autowired
    private com.nutricion.nutricion.services.users.UserService userService;
    
    @GetMapping("users")
    public ResponseEntity<ApiResponseDTO<CustomPageDTO<UserDTO>>> getUsers(@RequestParam(value = "page") int page) {
        return ResponseEntity.ok(new ApiResponseDTO<>(200,"SUCCESS",userService.getUsers(page)));
    }
}
