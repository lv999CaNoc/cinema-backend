package com.example.cinema.pojo.dto;

import com.example.cinema.pojo.entity.BillStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BillDto {
    private Long id;
    private BillStatus status;
    private LocalDateTime createdTime;
    private ScheduleDto schedule;
    private UserDto user;
}
