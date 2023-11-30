package com.example.cinema.pojo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "movies")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false)
    @NotBlank(message = "Tên phim không được để trống.")
    private String title;


    @Column(length = 1000)
    @NotBlank(message = "Mô tả phim không được để trống.")
    private String description;
    private Integer duration;
    private LocalDateTime releaseDate;
    private LocalDateTime endDate;
    private String director;
    private String actors;
    private Rated rated;
    private double likePercentage;
    private double revenuePercentage;

    @Column(length = 1000, name = "trailer_url")
    private String trailerURL;

    @Column(length = 1000, name = "movie_image_url")
    private String movieImageURl;

    @Column(length = 1000, name = "banner_image_url")
    private String bannerImageURl;

    @ManyToMany
    @JoinTable(name = "movie_categories", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;
}