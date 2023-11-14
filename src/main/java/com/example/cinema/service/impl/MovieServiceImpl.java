package com.example.cinema.service.impl;

import com.example.cinema.exception.CinemaException;
import com.example.cinema.exception.ExceptionCode;
import com.example.cinema.pojo.entity.Movie;
import com.example.cinema.pojo.requests.MovieDto;
import com.example.cinema.pojo.responses.BaseResponse;
import com.example.cinema.repository.MovieRepository;
import com.example.cinema.service.MovieService;
import com.example.cinema.util.DateUtils;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<?> getMovieById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new CinemaException(ExceptionCode.MOVIE_NOT_FOUND));
        return response(mapToDTO(movie));
    }

    @Override
    public ResponseEntity<?> listNowShowingMovies(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Movie> movies = movieRepository.listMovieNowShowing(new Date(), pageable);
        List<Movie> movieList = movies.getContent();
        List<MovieDto> content = movieList.stream().map(this::mapToDTO).toList();
        return response(content);
    }

    @Override
    public ResponseEntity<?> listComingSoonMovies(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Movie> movies = movieRepository.findByReleaseDateAfter(new Date(), pageable);
        List<Movie> movieList = movies.getContent();
        List<MovieDto> content = movieList.stream().map(this::mapToDTO).toList();
        return response(content);
    }

    @Override
    public ResponseEntity<?> listNewlyReleasedMovies(Integer pageNo, Integer pageSize, Integer months) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        LocalDate date = LocalDate.now().plusMonths(months);
        Page<Movie> movies = movieRepository.listMovieNewlyRelease(DateUtils.asDate(date), pageable);
        List<Movie> movieList = movies.getContent();
        List<MovieDto> content = movieList.stream().map(this::mapToDTO).toList();
        return response(content);
    }

    private MovieDto mapToDTO(Movie movie) {
        return modelMapper.map(movie, MovieDto.class);
    }

    private Movie mapToEntity(MovieDto movieDto) {
        return modelMapper.map(movieDto, Movie.class);
    }

    private ResponseEntity<?> response(Object object) {
        return ResponseEntity.ok(BaseResponse.of(object));
    }
}
