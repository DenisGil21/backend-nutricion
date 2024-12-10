package com.nutricion.nutricion.services.users;

import com.nutricion.nutricion.dtos.CustomPageDTO;
import com.nutricion.nutricion.dtos.UserDTO;

public interface UserService {
    public CustomPageDTO<UserDTO> getUsers(int page);
}
