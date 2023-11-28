package com.example.cinema.controller;

import com.example.cinema.pojo.requests.MovieFilterRequest;
import com.example.cinema.pojo.requests.ScheduleFilterRequest;
import com.example.cinema.service.MovieService;
import com.example.cinema.util.Constants;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/movies")
@AllArgsConstructor
public class MovieController {
    private MovieService movieService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable Long id){
        return movieService.getMovieById(id);
    }
    @GetMapping("/now-showing")
    public ResponseEntity<?> listNowShowingMovies(@RequestParam(value = "pageNo", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false) Integer pageNo,
                                                  @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false) Integer pageSize){
        return movieService.listNowShowingMovies(pageNo, pageSize);
    }
    @GetMapping("/coming-soon")
    public ResponseEntity<?> listComingSoonMovies(@RequestParam(value = "pageNo", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false) Integer pageNo,
                                                  @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false) Integer pageSize){
        return movieService.listComingSoonMovies(pageNo, pageSize);
    }
    @GetMapping("/newly-release")
    public ResponseEntity<?> listNewlyReleasedMovies(@RequestParam(value = "pageNo", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false) Integer pageNo,
                                                     @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false) Integer pageSize,
                                                     @RequestParam(value = "days", defaultValue = Constants.DEFAULT_DAY, required = false) Integer days) {
        return movieService.listNewlyReleasedMovies(pageNo, pageSize, days);
    }
    @GetMapping("/filter")
    public ResponseEntity<?> listMoviesFilter(@RequestParam(value = "pageNo", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false) Integer pageNo,
                                              @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false) Integer pageSize,
                                              @RequestBody MovieFilterRequest request){
        return movieService.listMoviesFilter(pageNo, pageSize, request);
    }
}
