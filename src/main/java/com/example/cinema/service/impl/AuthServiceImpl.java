package com.example.cinema.service.impl;

import com.example.cinema.exception.CinemaException;
import com.example.cinema.exception.ExceptionCode;
import com.example.cinema.pojo.requests.LoginRequest;
import com.example.cinema.pojo.requests.RegisterRequest;
import com.example.cinema.pojo.entity.Role;
import com.example.cinema.pojo.entity.User;
import com.example.cinema.pojo.responses.AuthenticationResponse;
import com.example.cinema.pojo.responses.BaseResponse;
import com.example.cinema.repository.RoleRepository;
import com.example.cinema.repository.UserRepository;
import com.example.cinema.security.JwtTokenProvider;
import com.example.cinema.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;

    private AuthenticationManager authenticationManager;

    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    private JwtTokenProvider jwtTokenProvider;

    public ResponseEntity<?> register(RegisterRequest request) {
        Optional<User> user = userRepository.findByUsername(request.getUsername());
        if(user.isPresent()) {
            if(request.getUsername().equals(user.get().getUsername())){
                throw new CinemaException(ExceptionCode.USERNAME_ALREADY_EXIST);
            }
            if(request.getEmail().equals(user.get().getEmail())) {
                throw new CinemaException(ExceptionCode.EMAIL_ALREADY_EXIST);
            }
            if(request.getPhoneNumber().equals(user.get().getPhoneNumber())) {
                throw new CinemaException(ExceptionCode.PHONE_ALREADY_EXIST);
            }
        }
        Role role = roleRepository.findByName("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        User newUser = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(roles)
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();
        userRepository.save(newUser);
        AuthenticationResponse response = AuthenticationResponse.builder()
                .token(jwtTokenProvider.generateToken(newUser))
                .build();
        return ResponseEntity.ok(BaseResponse.of(response));
    }

    @Override
    public ResponseEntity<?> login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        AuthenticationResponse response = AuthenticationResponse.builder()
                .token(jwtTokenProvider.generateToken(authentication))
                .build();
        return ResponseEntity.ok(BaseResponse.of(response));
    }
}
