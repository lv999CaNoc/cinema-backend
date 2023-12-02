package com.example.cinema.pojo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScheduleDto {
    private Integer id;
    private LocalDateTime startDate;
    private Double price;
    private MovieDto movie;
    private RoomDto room;
}
