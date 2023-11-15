package com.example.cinema.repository;

import com.example.cinema.pojo.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;


public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query(value = "SELECT * FROM movies WHERE release_date < :currentDate AND end_date > :currentDate", nativeQuery = true)
    Page<Movie> listMovieNowShowing(@Param("currentDate") Date currentDate, Pageable pageable);
    Page<Movie> findByReleaseDateAfter(Date currentDate, Pageable pageable);
    @Query(value = "SELECT * FROM movies WHERE TIMESTAMPDIFF(DAY, :currentDate, release_date) < :days", nativeQuery = true)
    Page<Movie> listMovieNewlyRelease(@Param("currentDate") Date currentDate,@Param("days") Integer days, Pageable pageable);
}

