package com.example.cinema.controller;

import com.example.cinema.pojo.requests.ScheduleFilterRequest;
import com.example.cinema.pojo.responses.BaseResponse;
import com.example.cinema.service.ScheduleService;
import com.example.cinema.util.Constants;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ScheduleController {
    private ScheduleService scheduleService;
    @GetMapping("/movies/{id}/schedules")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse getAllScheduleByMovie(@PathVariable Long id,
                                              @RequestParam(value = "pageNo", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false) Integer pageNo,
                                              @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false) Integer pageSize,
                                              @RequestParam(value = "sortBy", defaultValue = Constants.SORT_BY_TIME, required = false) String sortBy,
                                              @RequestParam(value = "sortDir", defaultValue = Constants.SORT_DIRECTION_ASC, required = false) String sortDir,
                                              @RequestParam(value = "dateTime", required = false) LocalDate dateTime
    ) {
        ScheduleFilterRequest request = ScheduleFilterRequest.builder()
                .sortBy(sortBy)
                .sortDir(sortDir)
                .date(dateTime)
                .build();
        return BaseResponse.of(scheduleService.getAllScheduleByMovie(id, pageNo, pageSize, request));
    }

    @GetMapping("schedules")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse getAllScheduleByMovieAndDate(@RequestParam("movieId") Long movieId,
                                                     @RequestParam("date") LocalDate date) {
        return BaseResponse.of(scheduleService.getAllScheduleByMovieAndDate(movieId, date));
    }
}
