package com.example.cinema.pojo.responses;

import com.example.cinema.pojo.dto.BillDto;
import com.example.cinema.pojo.dto.UserDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BillsResponse {
    private UserDto user;
    private List<BillDto> bills;
}
