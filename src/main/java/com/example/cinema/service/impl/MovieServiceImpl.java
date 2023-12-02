package com.example.cinema.service.impl;

import com.example.cinema.exception.CinemaException;
import com.example.cinema.exception.ExceptionCode;
import com.example.cinema.pojo.dto.MovieDto;
import com.example.cinema.pojo.entity.Movie;
import com.example.cinema.pojo.entity.Rated;
import com.example.cinema.pojo.requests.MovieFilterRequest;
import com.example.cinema.pojo.responses.BaseResponse;
import com.example.cinema.repository.MovieRepository;
import com.example.cinema.service.MovieService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        Page<Movie> movies = movieRepository.listMovieNowShowing(LocalDateTime.now(), pageable);
        List<Movie> movieList = movies.getContent();
        List<MovieDto> content = movieList.stream().map(this::mapToDTO).toList();
        return response(content);
    }

    @Override
    public ResponseEntity<?> listComingSoonMovies(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Movie> movies = movieRepository.findByReleaseDateAfter(LocalDateTime.now(), pageable);
        List<Movie> movieList = movies.getContent();
        List<MovieDto> content = movieList.stream().map(this::mapToDTO).toList();
        return response(content);
    }

    @Override
    public ResponseEntity<?> listNewlyReleasedMovies(Integer pageNo, Integer pageSize, Integer days) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Movie> movies = movieRepository.listMovieNewlyRelease(LocalDateTime.now(), days, pageable);
        List<Movie> movieList = movies.getContent();
        List<MovieDto> content = movieList.stream().map(this::mapToDTO).toList();
        return response(content);
    }

    @Override
    public ResponseEntity<?> listMoviesFilter(Integer pageNo, Integer pageSize, MovieFilterRequest request) {
        String keyword = request.getKeyword();
        List<Integer> ratedList = request.getRatedList();
        List<Integer> categories = request.getCategories();
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<Rated> enumRated = null;
        if(ratedList != null){
            enumRated = ratedList.stream().map(value -> Rated.values()[value]).toList();
        }
        Page<Movie> movies = movieRepository.searchMovies(keyword, enumRated, categories, pageable);
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
