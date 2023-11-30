package com.example.cinema.pojo.requests;

import lombok.Data;

import java.util.List;

@Data
public class BookingRequestDto {
    private Long userId;
    private Integer scheduleId;
    private List<Long> listSeatIds;
}