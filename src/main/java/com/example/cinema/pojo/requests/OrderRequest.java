package com.example.cinema.pojo.requests;

import lombok.Data;

@Data
public class OrderRequest {
    private Long billId;
    private double price;
    private String description;
}
