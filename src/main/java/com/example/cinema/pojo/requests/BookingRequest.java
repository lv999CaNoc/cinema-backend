package com.example.cinema.pojo.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BookingRequest {
    private Long userId;
    private Long scheduleId;
    private List<Long> listSeatIds;
}