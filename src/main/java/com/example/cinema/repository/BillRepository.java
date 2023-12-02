package com.example.cinema.repository;

import com.example.cinema.pojo.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> getAllByUserId(Long userId);
}
