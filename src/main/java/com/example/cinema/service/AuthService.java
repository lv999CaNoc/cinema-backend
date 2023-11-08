package com.example.cinema.service;

import com.example.cinema.pojo.responses.AuthenticationResponse;
import com.example.cinema.pojo.requests.RegisterRequest;
public interface AuthService {
    AuthenticationResponse register(RegisterRequest request);
}
