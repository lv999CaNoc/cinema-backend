package com.example.cinema.service;

import com.example.cinema.pojo.entity.User;
import com.example.cinema.pojo.requests.LoginRequest;
import com.example.cinema.pojo.requests.RegisterRequest;
import jakarta.mail.MessagingException;
import org.springframework.http.ResponseEntity;

import java.io.UnsupportedEncodingException;

public interface AuthService {
    ResponseEntity<?> register(RegisterRequest request);

    void sendRegisterVerifyEmail(User user)
            throws MessagingException, UnsupportedEncodingException;

    boolean verifyEmail(String token);

    ResponseEntity<?> login(LoginRequest request);

    User getUser() throws RuntimeException;
}
