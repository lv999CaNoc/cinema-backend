package com.example.cinema.repository;

import com.example.cinema.pojo.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {
    @Query(value = "SELECT * FROM bills WHERE created_time < :time AND status = :status", nativeQuery = true)
    List<Bill> findByCreatedTimeBeforeAndStatus(LocalDateTime time, int status);

    List<Bill> getAllByUserId(Long userId);
}
