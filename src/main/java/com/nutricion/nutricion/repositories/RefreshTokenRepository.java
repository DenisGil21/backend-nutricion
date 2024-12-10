package com.nutricion.nutricion.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.nutricion.nutricion.entities.RefreshToken;
import com.nutricion.nutricion.entities.User;



public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Integer>{
    Optional<RefreshToken> findByToken(String token);

    @Modifying
    int deleteByUser(User user);
}
