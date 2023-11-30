package com.example.cinema.pojo.requests;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ScheduleFilterRequest {
    private String sortBy;
    private String sortDir;
    private LocalDate date;
}
