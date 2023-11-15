package com.example.cinema.service.impl;

import com.example.cinema.pojo.entity.Category;
import com.example.cinema.pojo.responses.BaseResponse;
import com.example.cinema.repository.CategoryRepository;
import com.example.cinema.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Override
    public ResponseEntity<?> listCategory(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Category> movies = categoryRepository.findAll(pageable);
        List<Category> categories = movies.getContent();
        return response(categories);
    }

    private ResponseEntity<?> response(Object object) {
        return ResponseEntity.ok(BaseResponse.of(object));
    }
}
