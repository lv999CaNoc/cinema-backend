package com.example.cinema.pojo.requests;

import com.example.cinema.pojo.entity.Rated;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class MovieDto {
    private Integer id;
    private String title;
    @NotBlank(message = "Mô tả phim không được để trống.")
    private String description;
    private Integer duration;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date releaseDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date endDate;
    private String director;
    private String actors;
    private Rated rated;
    private Double likePercentage;
    private Double revenuePercentage;
    private String trailerURL;
    private String movieImageURl;
    private String bannerImageURl;
}
