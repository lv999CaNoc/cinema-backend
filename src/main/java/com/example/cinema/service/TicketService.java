package com.example.cinema.service;

public interface TicketService {
    boolean isSeatAvailable(Long scheduleId, Long seatId);
}
