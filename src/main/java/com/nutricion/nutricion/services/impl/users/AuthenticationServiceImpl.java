package com.nutricion.nutricion.services.impl.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nutricion.nutricion.dtos.UserDTO;
import com.nutricion.nutricion.entities.User;
import com.nutricion.nutricion.mappers.UserMapper;
import com.nutricion.nutricion.repositories.UserRepository;
import com.nutricion.nutricion.services.users.AuthenticationService;


@Service
public class AuthenticationServiceImpl implements AuthenticationService{
    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationServiceImpl(
        UserRepository userRepository,
        AuthenticationManager authenticationManager,
        PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDTO signup(UserDTO userDTO){
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User user = UserMapper.mapUser(userDTO);
        userRepository.save(user);
        return userDTO;
    }

     public User authenticate(UserDTO userDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDTO.getUsername(),
                        userDTO.getPassword()
                )
        );

        return userRepository.findByUsername(userDTO.getUsername())
        .orElseThrow();
    }
}
