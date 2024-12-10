package com.nutricion.nutricion.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.nutricion.nutricion.dtos.CustomPageDTO;
import com.nutricion.nutricion.dtos.UserDTO;
import com.nutricion.nutricion.entities.User;


public class UserMapper {
    private static final ModelMapper MAPPER = new ModelMapper();

    private UserMapper() {
        throw new IllegalStateException("No existe un constructor para la clase");
    }

    public static User mapUser(UserDTO userDTO) {
        return MAPPER.map(userDTO, User.class);
    }

    public static UserDTO mapUserDTO(User user) {
        return MAPPER.map(user, UserDTO.class);
    }

    public static CustomPageDTO<UserDTO> convertToDtoPage(Page<User> users) {
        List<UserDTO> userDTOs = users.stream()
                .map(user -> MAPPER.map(user, UserDTO.class))
                .collect(Collectors.toList());
        Page<UserDTO> userDTOPage = new PageImpl<>(userDTOs, users.getPageable(), users.getTotalElements());
        return new CustomPageDTO<>(userDTOPage);
    }
}
