package com.example.cinema.pojo.requests;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ScheduleFilterRequest {
    private Integer sortBy;
    private Integer sortDir;
    private LocalDate date;
}
