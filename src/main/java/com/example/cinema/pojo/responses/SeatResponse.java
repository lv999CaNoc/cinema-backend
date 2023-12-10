package com.example.cinema.pojo.responses;

import com.example.cinema.pojo.entity.BillStatus;
import lombok.Data;

@Data
public class SeatResponse {
    private int id;
    private String name;
    private BillStatus status;
}
