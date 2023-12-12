package com.example.cinema.service;

import com.example.cinema.pojo.entity.SecureToken;

public interface SecureTokenService {
    SecureToken createSecureToken();

    void saveSecureToken(SecureToken token);

    SecureToken findByToken(String token);

    void removeToken(SecureToken token);

    void removeTokenByToken(String token);
}
