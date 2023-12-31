package com.example.cinema.repository;

import com.example.cinema.pojo.entity.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query("SELECT s FROM Schedule s LEFT JOIN s.movie m " +
            "LEFT JOIN s.room r WHERE m.id = :movieId AND s.startDate >= :from AND s.startDate <= :to")
    Page<Schedule> listScheduleFilterByMovieId(@Param("movieId") Long movieId, @Param("from") LocalDateTime from, @Param("to") LocalDateTime to, Pageable pageable);

    @Query("SELECT s FROM Schedule s WHERE s.movie.id=:movieId And s.startDate>=:startOfDay AND s.startDate <= :endOfDay")
    List<Schedule> findByMovieIdAndDate(@Param("movieId") Long movieId,
                                        @Param("startOfDay") LocalDateTime startOfDay,
                                        @Param("endOfDay") LocalDateTime endOfDay);
}
