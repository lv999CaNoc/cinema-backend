package com.example.cinema.service.impl;

import com.example.cinema.pojo.entity.Schedule;
import com.example.cinema.pojo.requests.ScheduleDto;
import com.example.cinema.pojo.requests.ScheduleFilterRequest;
import com.example.cinema.pojo.responses.BaseResponse;
import com.example.cinema.repository.ScheduleRepository;
import com.example.cinema.service.ScheduleService;
import com.example.cinema.util.Constants;
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

    @Override
    public ResponseEntity<?> listSchedule(Long id, Integer pageNo, Integer pageSize, ScheduleFilterRequest request) {
        int sortBy = (request.getSortBy() == null ? Constants.SORT_BY_TIME : request.getSortBy());
        int sortDir = (request.getSortDir() == null ? Constants.SORT_DIRECTION_ASC : request.getSortDir());
        LocalDate date = (request.getDate() == null ? LocalDate.now() : request.getDate());
        Pageable pageable;
        Page<Schedule> schedules;
        if (sortBy == Constants.SORT_BY_TIME) {
            Sort sortTime = sortDir == Constants.SORT_DIRECTION_ASC ? Sort.by("startDate").ascending()
                    : Sort.by("startDate").descending();
            pageable = PageRequest.of(pageNo, pageSize, sortTime);
            schedules = scheduleRepository.listScheduleFilterByMovieId(id, date.atStartOfDay(), date.plusDays(1).atStartOfDay(), pageable);
        } else {
            Sort sortPrice = sortDir == Constants.SORT_DIRECTION_ASC ? Sort.by("price").ascending()
                    : Sort.by("price").descending();
            pageable = PageRequest.of(pageNo, pageSize, sortPrice);
            schedules = scheduleRepository.listScheduleFilterByMovieId(id, date.atStartOfDay(), date.plusDays(1).atStartOfDay(), pageable);
        }
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
