package com.nutricion.nutricion.services.impl.users;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.RuntimeCryptoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutricion.nutricion.entities.RefreshToken;
import com.nutricion.nutricion.repositories.RefreshTokenRepository;
import com.nutricion.nutricion.repositories.UserRepository;
import com.nutricion.nutricion.services.users.RefreshTokenService;

import jakarta.transaction.Transactional;

@Service
public class RefreshTokenServiceImpl implements RefreshTokenService{
    
    @Autowired
    private RefreshTokenRepository refreshTokenRepository;
    
    @Autowired
    private UserRepository userRepository;

    public RefreshToken createRefreshToken(String username){
        RefreshToken refreshToken = RefreshToken.builder()
        .user(userRepository.findByUsername(username).get())
        .token(UUID.randomUUID().toString())
        .expiryDate(Instant.now().plusMillis(600000))// 10min
        .build();
        return refreshTokenRepository.save(refreshToken);
    }

    public Optional<RefreshToken> findByToken(String token){
        return refreshTokenRepository.findByToken(token);
    }

    public RefreshToken verifyExpiration(RefreshToken token){
        if (token.getExpiryDate().compareTo(Instant.now())< 0) {
            refreshTokenRepository.delete(token);
            throw new RuntimeCryptoException(token.getToken() + " Refresh token was expired. Please make a new signin request");
        }
        return token;
    }

    @Transactional
    public int deleteByUserId(Long userId) {
      return refreshTokenRepository.deleteByUser(userRepository.findById(userId).get());
    }
}
