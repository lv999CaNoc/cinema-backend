package com.example.cinema.service;

import com.example.cinema.dto.AuthenticationResponse;
import com.example.cinema.dto.RegisterRequest;
public interface AuthService {
    AuthenticationResponse register(RegisterRequest request);
}
