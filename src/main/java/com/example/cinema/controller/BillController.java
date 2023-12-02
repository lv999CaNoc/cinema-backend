package com.example.cinema.controller;

import com.example.cinema.pojo.dto.BillDto;
import com.example.cinema.pojo.requests.BookingRequest;
import com.example.cinema.pojo.responses.BaseResponse;
import com.example.cinema.service.BillService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bill")
@AllArgsConstructor
public class BillController {
    private BillService billService;

    @PostMapping("")
    public ResponseEntity<?> createBill(@RequestBody BookingRequest booking) {
        BillDto bill = billService.create(booking);
        return ResponseEntity.ok(BaseResponse.of(bill));
    }
}
