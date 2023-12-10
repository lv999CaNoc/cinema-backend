package com.example.cinema.service;

import com.example.cinema.pojo.responses.SeatResponse;

import java.util.List;

public interface SeatService {
    List<SeatResponse> getSeatByScheduleId(Long scheduleId);
}
