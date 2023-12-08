package com.example.cinema.repository;

import com.example.cinema.pojo.entity.Movie;
import com.example.cinema.pojo.entity.Rated;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;


public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT m FROM Movie m WHERE m.releaseDate < :currentDate AND m.endDate > :currentDate")
    Page<Movie> listMovieNowShowing(@Param("currentDate") LocalDateTime currentDate, Pageable pageable);
    Page<Movie> findByReleaseDateAfter(LocalDateTime currentDate, Pageable pageable);
    @Query(value = "SELECT * FROM movies WHERE TIMESTAMPDIFF(DAY, release_date, :currentDate)> 0 AND TIMESTAMPDIFF(DAY, release_date, :currentDate) < :days", nativeQuery = true)
    Page<Movie> listMovieNewlyRelease(@Param("currentDate") LocalDateTime currentDate,@Param("days") Integer days, Pageable pageable);

    @Query("SELECT DISTINCT m FROM Movie m LEFT JOIN FETCH m.categories c" +
            " WHERE (:rated IS NULL OR m.rated IN (:rated)) " +
            "AND (:categories IS NULL OR c.id IN :categories) " +
            "AND (:keyword IS NULL OR UPPER(m.actors) LIKE UPPER(CONCAT('%', :keyword, '%')) " +
            "OR UPPER(m.director) LIKE UPPER(CONCAT('%', :keyword, '%')) " +
            "OR UPPER(m.description) LIKE UPPER(CONCAT('%', :keyword, '%'))" +
            "OR UPPER(m.title) LIKE UPPER(CONCAT('%', :keyword, '%'))" +
            "OR UPPER(c.name) LIKE UPPER(CONCAT('%', :keyword, '%')))")
    Page<Movie> searchMovies(@Param("keyword") String keyword, @Param("rated") List<Rated> rated, @Param("categories") List<Integer> categories, Pageable pageable);
}

