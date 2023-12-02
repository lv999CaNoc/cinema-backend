package com.example.cinema.service;

import com.example.cinema.pojo.dto.BillDto;
import com.example.cinema.pojo.requests.BookingRequest;
import org.springframework.transaction.annotation.Transactional;

public interface BillService {
    @Transactional
    BillDto create(BookingRequest bookingRequest) throws RuntimeException;

}
