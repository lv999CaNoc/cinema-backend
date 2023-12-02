package com.example.cinema.pojo.dto;

import lombok.Data;

@Data
public class SeatDto {
    Long id;
    String name;
    RoomDto room;
}
