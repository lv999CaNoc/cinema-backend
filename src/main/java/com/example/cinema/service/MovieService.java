package com.example.cinema.service;

import com.example.cinema.pojo.dto.MovieDto;
import com.example.cinema.pojo.requests.MovieFilterRequest;

import java.util.List;

public interface MovieService {
    MovieDto getMovieById(Long id);

    List<MovieDto> getAllNowShowingMovies(Integer pageNo, Integer pageSize);

    List<MovieDto> getAllComingSoonMovies(Integer pageNo, Integer pageSize);

    List<MovieDto> getAllNewlyReleasedMovies(Integer pageNo, Integer pageSize, Integer days);

    List<MovieDto> getAllMovieWithFilter(Integer pageNo, Integer pageSize, MovieFilterRequest request);
}
