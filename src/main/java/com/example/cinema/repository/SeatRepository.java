package com.example.cinema.repository;

import com.example.cinema.pojo.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    @Query("SELECT DISTINCT s FROM Seat s " +
            "LEFT JOIN s.room r " +
            "LEFT JOIN Schedule sc ON s.room.id = sc.room.id " +
            "WHERE s.room.id = :roomId AND sc.id = :scheduleId")
    List<Seat> findAllByScheduleAndRoom(@Param("scheduleId") Long scheduleId, @Param("roomId") Long roomId);

    List<Seat> getSeatByRoom_Id(Integer roomId);
}
