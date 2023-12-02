package com.example.cinema.service.impl;

import com.example.cinema.exception.CinemaException;
import com.example.cinema.exception.ExceptionCode;
import com.example.cinema.pojo.dto.BillDto;
import com.example.cinema.pojo.entity.Bill;
import com.example.cinema.pojo.entity.BillStatus;
import com.example.cinema.pojo.entity.Schedule;
import com.example.cinema.pojo.entity.User;
import com.example.cinema.pojo.requests.BookingRequest;
import com.example.cinema.repository.BillRepository;
import com.example.cinema.repository.ScheduleRepository;
import com.example.cinema.service.AuthService;
import com.example.cinema.service.BillService;
import com.example.cinema.service.TicketService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BillServiceImpl implements BillService {
    private BillRepository billRepository;
    private ScheduleRepository scheduleRepository;

    private TicketService ticketService;
    private AuthService authService;

    private ModelMapper modelMapper;

    @Override
    @Transactional
    public BillDto create(BookingRequest bookingRequest) throws RuntimeException {
        // check seat available
        bookingRequest.getListSeatIds().stream().forEach(seatId -> {
            if (!ticketService.isSeatAvailable(bookingRequest.getScheduleId(), seatId)) {
                // someone else booked
                throw new CinemaException(ExceptionCode.SEAT_NOT_AVAIlABLE);
            }
        });

        User user = authService.getUser();
        Schedule schedule = scheduleRepository.getById(bookingRequest.getScheduleId());

        // create bill
        Bill billToCreate = Bill.builder()
                .status(BillStatus.PENDING)
                .schedule(schedule)
                .createdTime(LocalDateTime.now())
                .user(user)
                .build();
        billRepository.save(billToCreate);

        // create ticket for each seat
        ticketService.create(bookingRequest, billToCreate);

        return modelMapper.map(billToCreate, BillDto.class);
    }

    @Override
    public List<BillDto> getAll() {
        Long userId = authService.getUser().getId();
        return billRepository.getAllByUserId(userId)
                .stream()
                .map(bill -> modelMapper.map(bill, BillDto.class))
                .collect(Collectors.toList());
    }
}
