package com.example.cinema.service.impl;

import com.example.cinema.dto.AuthenticationResponse;
import com.example.cinema.dto.RegisterRequest;
import com.example.cinema.entity.Role;
import com.example.cinema.entity.User;
import com.example.cinema.repository.RoleRepository;
import com.example.cinema.repository.UserRepository;
import com.example.cinema.security.JwtTokenProvider;
import com.example.cinema.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    private JwtTokenProvider jwtTokenProvider;

    public AuthenticationResponse register(RegisterRequest request) {
        //TEST CODE
        Role role = roleRepository.findByName("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        var user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(roles)
                .build();
        userRepository.save(user);
        var jwtToken = jwtTokenProvider.generateToken(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
