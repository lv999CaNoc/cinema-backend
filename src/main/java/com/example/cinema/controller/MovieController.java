package com.example.cinema.controller;

import com.example.cinema.pojo.requests.MovieFilterRequest;
import com.example.cinema.pojo.responses.BaseResponse;
import com.example.cinema.service.MovieService;
import com.example.cinema.util.Constants;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/movies")
@AllArgsConstructor
public class MovieController {
    private MovieService movieService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse getMovieById(@PathVariable Long id){
        return BaseResponse.of(movieService.getMovieById(id));
    }
    @GetMapping("/now-showing")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse getAllNowShowingMovies(@RequestParam(value = "pageNo", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false) Integer pageNo,
                                               @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false) Integer pageSize){
        return BaseResponse.of(movieService.getAllNowShowingMovies(pageNo, pageSize));
    }
    @GetMapping("/coming-soon")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse getAllComingSoonMovies(@RequestParam(value = "pageNo", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false) Integer pageNo,
                                               @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false) Integer pageSize){
        return BaseResponse.of(movieService.getAllComingSoonMovies(pageNo, pageSize));
    }
    @GetMapping("/newly-release")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse getAllNewlyReleasedMovies(@RequestParam(value = "pageNo", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false) Integer pageNo,
                                                  @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false) Integer pageSize,
                                                  @RequestParam(value = "days", defaultValue = Constants.DEFAULT_DAY, required = false) Integer days) {
        return BaseResponse.of(movieService.getAllNewlyReleasedMovies(pageNo, pageSize, days));
    }
    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse getAllMovieWithFilter(@RequestParam(value = "pageNo", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false) Integer pageNo,
                                              @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false) Integer pageSize,
                                              @RequestParam(value = "q", required = false) String keyword,
                                              @RequestParam(value = "rated", required = false) List<Integer> ratedList,
                                              @RequestParam(value = "categories", required = false) List<Integer> categories){
        MovieFilterRequest request = MovieFilterRequest.builder()
                .keyword(keyword)
                .ratedList(ratedList)
                .categories(categories)
                .build();
        return BaseResponse.of(movieService.getAllMovieWithFilter(pageNo, pageSize, request));
    }
}
