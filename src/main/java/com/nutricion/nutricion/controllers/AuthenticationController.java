package com.nutricion.nutricion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutricion.nutricion.dtos.ApiResponseDTO;
import com.nutricion.nutricion.dtos.LoginResponseDTO;
import com.nutricion.nutricion.dtos.RefreshTokenRequestDTO;
import com.nutricion.nutricion.dtos.UserDTO;
import com.nutricion.nutricion.entities.RefreshToken;
import com.nutricion.nutricion.entities.User;
import com.nutricion.nutricion.services.users.AuthenticationService;
import com.nutricion.nutricion.services.users.JwtService;
import com.nutricion.nutricion.services.users.RefreshTokenService;



@RequestMapping("/api/auth")
@RestController
public class AuthenticationController {
    
    @Autowired
    private final JwtService jwtService;
    
    @Autowired
    private final AuthenticationService authenticationService;

    @Autowired
    private RefreshTokenService refreshTokenService;

      public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponseDTO<UserDTO>> register(@RequestBody UserDTO registerUserDto) {

        return ResponseEntity.ok(new ApiResponseDTO<>(200,"SUCCESS",authenticationService.signup(registerUserDto)));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponseDTO<LoginResponseDTO>> authenticate(@RequestBody UserDTO loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);
        refreshTokenService.deleteByUserId(authenticatedUser.getId());
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(loginUserDto.getUsername());
        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponseDTO loginResponse = new LoginResponseDTO().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime()).setRefreshToken(refreshToken.getToken());

        return ResponseEntity.ok(new ApiResponseDTO<>(200,"SUCCESS",loginResponse));
    }

    @PostMapping("/refreshToken")
    public LoginResponseDTO refreshToken(@RequestBody RefreshTokenRequestDTO refreshTokenRequestDTO) {
        return refreshTokenService.findByToken(refreshTokenRequestDTO.getToken())
        .map(refreshTokenService::verifyExpiration)
        .map(RefreshToken::getUser)
        .map(user -> {
            String accessToken = jwtService.generateToken(user);
            return LoginResponseDTO.builder()
            .token(accessToken)
            .refreshToken(refreshTokenRequestDTO.getToken())
            .build();
        }).orElseThrow(()-> new RuntimeException("Refresh token is not in database"));
        
    }
    

}
