package com.example.cinema.service;

import org.springframework.http.ResponseEntity;

public interface MovieService {
    ResponseEntity<?> getMovieById(Long id);

    ResponseEntity<?> listNowShowingMovies(Integer pageNo, Integer pageSize);

    ResponseEntity<?> listComingSoonMovies(Integer pageNo, Integer pageSize);

    ResponseEntity<?> listNewlyReleasedMovies(Integer pageNo, Integer pageSize, Integer months);
}
