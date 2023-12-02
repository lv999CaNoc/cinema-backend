package com.example.cinema.pojo.dto;

import lombok.Data;

@Data
public class TheaterDto {
    private Integer id;
    private String name;
    private String address;
    private String city;
    private String phoneNumber;
    private UserDto manager;
}
