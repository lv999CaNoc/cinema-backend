package com.example.cinema.service;

import com.example.cinema.pojo.requests.LoginRequest;
import com.example.cinema.pojo.responses.AuthenticationResponse;
import com.example.cinema.pojo.requests.RegisterRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> register(RegisterRequest request);
    ResponseEntity<?> login(LoginRequest request);
}
