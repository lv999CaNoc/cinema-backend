package com.example.cinema.service.impl;

import com.example.cinema.exception.CinemaException;
import com.example.cinema.exception.ExceptionCode;
import com.example.cinema.pojo.dto.SeatDto;
import com.example.cinema.pojo.entity.Seat;
import com.example.cinema.pojo.responses.BaseResponse;
import com.example.cinema.repository.RoomRepository;
import com.example.cinema.repository.ScheduleRepository;
import com.example.cinema.repository.SeatRepository;
import com.example.cinema.service.SeatService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeatServiceImpl implements SeatService {
    private ModelMapper modelMapper;
    private ScheduleRepository scheduleRepository;
    private SeatRepository seatRepository;
    private RoomRepository roomRepository;

    @Override
    public ResponseEntity<?> listSeat(Long scheduleId, Long roomId) {
        roomRepository.findById(roomId)
                .orElseThrow(() -> new CinemaException(ExceptionCode.ROOM_NOT_FOUND));
        scheduleRepository.findById(scheduleId)
                .orElseThrow(()-> new CinemaException(ExceptionCode.SCHEDULE_NOT_FOUND));
        List<Seat> seats = seatRepository.findAllByScheduleAndRoom(scheduleId, roomId);
        List<SeatDto> seatDtos = seats.stream().map(this::mapToDTO).toList();
        return response(seatDtos);
    }

    private SeatDto mapToDTO(Seat seat) {
        return modelMapper.map(seat, SeatDto.class);
    }

    private Seat mapToEntity(SeatDto seatDto) {
        return modelMapper.map(seatDto, Seat.class);
    }
    private ResponseEntity<?> response(Object object) {
        return ResponseEntity.ok(BaseResponse.of(object));
    }
}
