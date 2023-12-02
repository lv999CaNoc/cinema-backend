package com.example.cinema.service;

import com.example.cinema.pojo.dto.TicketDto;
import com.example.cinema.pojo.entity.Bill;
import com.example.cinema.pojo.requests.BookingRequest;

import java.util.List;

public interface TicketService {
    boolean isSeatAvailable(Long scheduleId, Long seatId);

    List<TicketDto> create(BookingRequest bookingRequest, Bill bill) throws RuntimeException;
}
