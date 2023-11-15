package com.example.cinema.pojo.requests;

import lombok.Data;

import java.util.List;
@Data
public class MovieFilterRequest {
    private List<Integer> ratedList;
    private List<Long> categoriesId;
    private Integer state;
}
