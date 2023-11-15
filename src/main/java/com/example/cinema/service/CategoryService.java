package com.example.cinema.service;

import org.springframework.http.ResponseEntity;

public interface CategoryService {
    ResponseEntity<?> listCategory(Integer pageNo, Integer pageSize);
}
