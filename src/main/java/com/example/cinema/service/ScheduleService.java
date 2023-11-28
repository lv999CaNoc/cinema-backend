package com.example.cinema.service;

import com.example.cinema.pojo.requests.ScheduleFilterRequest;
import org.springframework.http.ResponseEntity;

public interface ScheduleService {
    ResponseEntity<?> listSchedule(Long id, Integer pageNo, Integer pageSize, ScheduleFilterRequest request);
}
