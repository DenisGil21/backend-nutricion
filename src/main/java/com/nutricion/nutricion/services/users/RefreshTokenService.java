package com.nutricion.nutricion.services.users;

import java.util.Optional;

import com.nutricion.nutricion.entities.RefreshToken;


public interface RefreshTokenService {
    public RefreshToken createRefreshToken(String username);

    public Optional<RefreshToken> findByToken(String token);

    public RefreshToken verifyExpiration(RefreshToken token);

    public int deleteByUserId(Long userId);
}
