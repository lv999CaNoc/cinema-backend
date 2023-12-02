package com.example.cinema.pojo.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String phoneNumber;
    private String firstName;
    private String lastName;
}
