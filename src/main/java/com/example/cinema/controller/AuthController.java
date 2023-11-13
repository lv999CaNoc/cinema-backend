package com.example.cinema.controller;

import com.example.cinema.pojo.requests.LoginRequest;
import com.example.cinema.pojo.requests.RegisterRequest;
import com.example.cinema.service.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    private AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        return authService.login(request);
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request){
        return authService.register(request);
    }
}
