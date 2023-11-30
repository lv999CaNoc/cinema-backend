package com.example.cinema.pojo.requests;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class MovieFilterRequest {
    private String keyword;
    private List<Integer> ratedList;
    private List<Integer> categories;
}
