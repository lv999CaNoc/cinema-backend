package com.example.cinema.service;

import com.example.cinema.pojo.dto.ScheduleDto;
import com.example.cinema.pojo.requests.ScheduleFilterRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ScheduleService {
    List<ScheduleDto> getAllScheduleByMovie(Long id, Integer pageNo, Integer pageSize, ScheduleFilterRequest request);
}
