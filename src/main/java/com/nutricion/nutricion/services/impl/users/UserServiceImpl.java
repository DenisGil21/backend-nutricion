package com.nutricion.nutricion.services.impl.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nutricion.nutricion.dtos.CustomPageDTO;
import com.nutricion.nutricion.dtos.UserDTO;
import com.nutricion.nutricion.entities.User;
import com.nutricion.nutricion.mappers.UserMapper;
import com.nutricion.nutricion.repositories.UserRepository;
import com.nutricion.nutricion.services.users.UserService;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public CustomPageDTO<UserDTO> getUsers(int page) {
        Pageable pagination = PageRequest.of(page - 1, 5);

        Page<User> users = userRepository.findByOrderByIdAsc(pagination);

        return UserMapper.convertToDtoPage(users);
    }
}
