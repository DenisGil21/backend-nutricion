package com.nutricion.nutricion.services.users;

import com.nutricion.nutricion.dtos.UserDTO;
import com.nutricion.nutricion.entities.User;

public interface AuthenticationService {
    
    public UserDTO signup(UserDTO userDTO);
    public User authenticate(UserDTO userDTO);

}
