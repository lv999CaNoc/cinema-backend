package com.example.cinema.service;

import com.example.cinema.pojo.dto.ScheduleDto;
import com.example.cinema.pojo.requests.ScheduleFilterRequest;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleService {
    List<ScheduleDto> getAllScheduleByMovie(Long id, Integer pageNo, Integer pageSize, ScheduleFilterRequest request);

    List<ScheduleDto> getAllScheduleByMovieAndDate(Long movieId, LocalDate date);
}
