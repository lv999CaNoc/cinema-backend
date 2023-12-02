package com.example.cinema.pojo.dto;

import com.example.cinema.pojo.entity.Category;
import com.example.cinema.pojo.entity.Rated;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MovieDto {
    private Integer id;
    private String title;
    private String description;
    private Integer duration;
    private LocalDateTime releaseDate;
    private LocalDateTime endDate;
    private String director;
    private String actors;
    private Rated rated;
    private Double likePercentage;
    private Double revenuePercentage;
    private String trailerURL;
    private String movieImageURl;
    private String bannerImageURl;
    private List<Category> categories;
}
