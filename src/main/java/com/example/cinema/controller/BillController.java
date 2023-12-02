package com.example.cinema.controller;

import com.example.cinema.pojo.dto.BillDto;
import com.example.cinema.pojo.requests.BookingRequest;
import com.example.cinema.pojo.responses.BaseResponse;
import com.example.cinema.service.BillService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("")
    public ResponseEntity<?> getAllBillByUser() {
        List<BillDto> bills = billService.getAll();
        return ResponseEntity.ok(BaseResponse.of(bills));
    }
}
