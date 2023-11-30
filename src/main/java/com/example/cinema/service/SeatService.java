package com.example.cinema.service;

import org.springframework.http.ResponseEntity;

public interface SeatService {
    ResponseEntity<?> listSeat(Long scheduleId, Long roomId);
}
