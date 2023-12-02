package com.example.cinema.pojo.dto;

import lombok.Data;

@Data
public class TicketDto {
    private int id;
    private String qrImageURL;
    private SeatDto seat;
    private BillDto bill;
}
