package com.example.cinema.controller;

import com.example.cinema.service.SeatService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class SeatController {
    private SeatService seatService;

    @GetMapping("/seats")
    public ResponseEntity<?> listSeat(@RequestParam Long scheduleId, @RequestParam Long roomId) {
        return seatService.listSeat(scheduleId, roomId);
    }
}
