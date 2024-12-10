package com.nutricion.nutricion.repositories;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nutricion.nutricion.entities.User;


public interface UserRepository extends JpaRepository<User, Long>{
    Page<User> findByOrderByIdAsc(Pageable pageable);
    Optional<User> findByUsername(String username);
}
