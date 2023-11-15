package com.example.cinema.service;

import com.example.cinema.pojo.requests.MovieFilterRequest;
import org.springframework.http.ResponseEntity;

public interface MovieService {
    ResponseEntity<?> getMovieById(Long id);

    ResponseEntity<?> listNowShowingMovies(Integer pageNo, Integer pageSize);

    ResponseEntity<?> listComingSoonMovies(Integer pageNo, Integer pageSize);

    ResponseEntity<?> listNewlyReleasedMovies(Integer pageNo, Integer pageSize, Integer days);

    ResponseEntity<?> listMoviesFilter(Integer pageNo, Integer pageSize, MovieFilterRequest request);
}
