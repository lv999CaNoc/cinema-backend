package com.example.cinema.service;

import com.example.cinema.pojo.dto.SeatDto;

import java.util.List;

public interface SeatService {
    List<SeatDto> getAllSeat(Long scheduleId, Long roomId);
}
