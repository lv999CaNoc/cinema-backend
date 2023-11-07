package com.example.cinema.service;

import com.example.cinema.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getUserById(Long userId);

    List<UserDto> getAllUser();

    UserDto updateUser(UserDto user);

    void deleteUser(Long userId);
}