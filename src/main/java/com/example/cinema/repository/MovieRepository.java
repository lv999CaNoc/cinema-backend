package com.example.cinema.repository;

import com.example.cinema.pojo.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;


public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT m FROM Movie m WHERE m.releaseDate < :currentDate AND m.endDate > :currentDate")
    Page<Movie> listMovieNowShowing(@Param("currentDate") LocalDateTime currentDate, Pageable pageable);
    Page<Movie> findByReleaseDateAfter(LocalDateTime currentDate, Pageable pageable);
    @Query(value = "SELECT * FROM movies WHERE TIMESTAMPDIFF(DAY, :currentDate, release_date) < :days",nativeQuery = true)
    Page<Movie> listMovieNewlyRelease(@Param("currentDate") LocalDateTime currentDate,@Param("days") Integer days, Pageable pageable);
}

