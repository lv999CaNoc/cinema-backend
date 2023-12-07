package com.example.cinema.service;

import com.example.cinema.pojo.dto.BillDto;
import com.example.cinema.pojo.requests.BookingRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BillService {
    @Transactional
    BillDto create(BookingRequest bookingRequest) throws RuntimeException;

    List<BillDto> getAll();

}
