package com.example.cinema.service.impl;

import com.example.cinema.exception.CinemaException;
import com.example.cinema.exception.ExceptionCode;
import com.example.cinema.pojo.entity.BillStatus;
import com.example.cinema.pojo.entity.Schedule;
import com.example.cinema.pojo.entity.Seat;
import com.example.cinema.pojo.entity.Ticket;
import com.example.cinema.pojo.responses.SeatResponse;
import com.example.cinema.repository.ScheduleRepository;
import com.example.cinema.repository.SeatRepository;
import com.example.cinema.repository.TicketRepository;
import com.example.cinema.service.SeatService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SeatServiceImpl implements SeatService {
    private ModelMapper modelMapper;

    private ScheduleRepository scheduleRepository;
    private SeatRepository seatRepository;
    private TicketRepository ticketRepository;

    @Override
    public List<SeatResponse> getSeatByScheduleId(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new CinemaException(ExceptionCode.SCHEDULE_NOT_FOUND));

        List<Seat> listSeat = seatRepository.getSeatByRoom_Id(schedule.getRoom().getId());

        List<Seat> bookedSeats = new ArrayList<>();
        List<Seat> processedSeats = new ArrayList<>();

        for (Ticket ticket : ticketRepository.findTicketsBySchedule_Id(scheduleId)) {
            BillStatus status = ticket.getBill().getStatus();
            if (status.equals(BillStatus.COMPLETE)) {
                bookedSeats.add(ticket.getSeat());
            } else if (status.equals(BillStatus.PENDING)) {
                processedSeats.add(ticket.getSeat());
            }
        }

        List<SeatResponse> filteredSeats = listSeat.stream().map(seat -> {
            SeatResponse seatResponse = modelMapper.map(seat, SeatResponse.class);
            if (bookedSeats.stream()
                    .map(bookedSeat -> bookedSeat.getId())
                    .collect(Collectors.toList()).contains(seat.getId())) {
                seatResponse.setStatus(BillStatus.COMPLETE);
            } else if (processedSeats.stream()
                    .map(bookedSeat -> bookedSeat.getId())
                    .collect(Collectors.toList()).contains(seat.getId())) {
                seatResponse.setStatus(BillStatus.PENDING);
            }
            return seatResponse;
        }).collect(Collectors.toList());
        return filteredSeats;
    }

}
