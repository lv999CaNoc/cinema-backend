package com.example.cinema.controller;

import com.example.cinema.pojo.dto.TicketDto;
import com.example.cinema.pojo.responses.BaseResponse;
import com.example.cinema.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class TicketController {
    private TicketService ticketService;
    @GetMapping("/bills/{id}/tickets")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse getAllTicketByBill(@PathVariable Long id) {
        return BaseResponse.of(ticketService.getAllTicketByBill(id));
    }
}
