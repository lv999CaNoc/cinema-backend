package com.example.cinema.pojo.requests;

import com.example.cinema.pojo.entity.Theater;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScheduleDto {
    private Integer id;
    private LocalDateTime startDate;
    private Double price;
    private String theater;
}
