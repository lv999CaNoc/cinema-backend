package com.example.cinema.controller;

import com.example.cinema.pojo.responses.BaseResponse;
import com.example.cinema.service.SeatService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seats")
@AllArgsConstructor
public class SeatController {
    private SeatService seatService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse getAllSeat(@RequestParam Long scheduleId) {
        return BaseResponse.of(seatService.getSeatByScheduleId(scheduleId));
    }
}
