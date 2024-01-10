package com.example.cinema.controller;

import com.example.cinema.pojo.dto.BillDto;
import com.example.cinema.pojo.dto.UserDto;
import com.example.cinema.pojo.entity.User;
import com.example.cinema.pojo.requests.BookingRequest;
import com.example.cinema.pojo.responses.BaseResponse;
import com.example.cinema.pojo.responses.BillsResponse;
import com.example.cinema.service.AuthService;
import com.example.cinema.service.BillService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bill")
@AllArgsConstructor
public class BillController {
    private BillService billService;
    private AuthService authService;
    private ModelMapper modelMapper;

    @PostMapping("")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> createBill(@RequestBody BookingRequest booking) {
        BillDto bill = billService.create(booking);
        return ResponseEntity.ok(BaseResponse.of(bill));
    }

    @GetMapping("")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_MANAGER')")
    public ResponseEntity<?> getAllBillByUser() {
        User user = authService.getUser();
        List<BillDto> bills = billService.getAll(user.getId());
        BillsResponse billsResponse = BillsResponse.builder()
                .user(modelMapper.map(user, UserDto.class))
                .bills(bills)
                .build();
        return ResponseEntity.ok(BaseResponse.of(billsResponse));
    }
}
