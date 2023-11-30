package com.example.cinema.service.impl;

import com.example.cinema.exception.CinemaException;
import com.example.cinema.exception.ExceptionCode;
import com.example.cinema.pojo.entity.Schedule;
import com.example.cinema.pojo.requests.ScheduleDto;
import com.example.cinema.pojo.requests.ScheduleFilterRequest;
import com.example.cinema.pojo.responses.BaseResponse;
import com.example.cinema.repository.MovieRepository;
import com.example.cinema.repository.ScheduleRepository;
import com.example.cinema.service.ScheduleService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private ModelMapper modelMapper;
    private ScheduleRepository scheduleRepository;
    private MovieRepository movieRepository;

    @Override
    public ResponseEntity<?> listSchedule(Long movieId, Integer pageNo, Integer pageSize, ScheduleFilterRequest request) {
        movieRepository.findById(movieId)
                .orElseThrow(()-> new CinemaException(ExceptionCode.MOVIE_NOT_FOUND));
        String sortBy = request.getSortBy();
        String sortDir = request.getSortDir();
        LocalDate date = (request.getDate() == null ? LocalDate.now() : request.getDate());
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() :
                Sort.by(sortDir).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Schedule> schedules = scheduleRepository.listScheduleFilterByMovieId(movieId, date.atStartOfDay(), date.plusDays(1).atStartOfDay(), pageable);
        List<Schedule> scheduleList = schedules.getContent();
        List<ScheduleDto> contents = scheduleList.stream().map(this::mapToDTO).toList();
        return response(contents);
    }

    private ScheduleDto mapToDTO(Schedule schedule) {
       ScheduleDto scheduleDto = modelMapper.map(schedule, ScheduleDto.class);
       scheduleDto.setTheater(schedule.getRoom().getTheater());
       scheduleDto.setRoom(schedule.getRoom());
       return scheduleDto;
    }

    private Schedule mapToEntity(ScheduleDto scheduleDto) {
        return modelMapper.map(scheduleDto, Schedule.class);
    }

    private ResponseEntity<?> response(Object object) {
        return ResponseEntity.ok(BaseResponse.of(object));
    }
}
