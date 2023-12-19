package com.example.cinema.controller;

import com.example.cinema.pojo.requests.QRCodeRequest;
import com.example.cinema.pojo.responses.BaseResponse;
import com.example.cinema.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("tickets/check")
    @PreAuthorize("hasAnyRole('ROLE_MANAGER')")
    public BaseResponse getTicketByQRcode(@RequestBody QRCodeRequest request) {
        return BaseResponse.of(ticketService.getTicketByQRcode(request.getToken()));
    }
}
