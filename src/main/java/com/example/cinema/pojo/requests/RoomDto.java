package com.example.cinema.pojo.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomDto {
    private Long id;
    private Integer capacity;
    private String name;
    private String theaterName;
}
