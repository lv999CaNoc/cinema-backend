package com.example.cinema.service;

import com.example.cinema.pojo.requests.BookingRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

public interface BillService {
    @Transactional
    ResponseEntity<?> createNewBill(BookingRequestDto bookingRequestDTO) throws RuntimeException;

    ResponseEntity<?> getBillById(Long billId);
}
