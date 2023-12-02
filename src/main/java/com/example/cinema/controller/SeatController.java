package com.example.cinema.controller;

import com.example.cinema.pojo.responses.BaseResponse;
import com.example.cinema.service.SeatService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class SeatController {
    private SeatService seatService;

    @GetMapping("/seats")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse getAllSeat(@RequestParam Long scheduleId, @RequestParam Long roomId) {
        return BaseResponse.of(seatService.getAllSeat(scheduleId, roomId));
    }
}
