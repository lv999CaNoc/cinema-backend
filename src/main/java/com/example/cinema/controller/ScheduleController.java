package com.example.cinema.controller;

import com.example.cinema.pojo.requests.ScheduleFilterRequest;
import com.example.cinema.service.ScheduleService;
import com.example.cinema.util.Constants;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ScheduleController {
    private ScheduleService scheduleService;
    @GetMapping("/movies/{id}/schedules")
    public ResponseEntity<?> listRoom(@PathVariable Long id,
                                      @RequestParam(value = "pageNo", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false) Integer pageNo,
                                      @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false) Integer pageSize,
                                      @RequestBody ScheduleFilterRequest request){
        return scheduleService.listSchedule(id, pageNo, pageSize, request);
    }
}
