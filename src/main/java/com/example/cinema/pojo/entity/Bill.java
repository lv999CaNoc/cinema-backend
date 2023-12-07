package com.example.cinema.pojo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "bills")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private LocalDateTime createdTime;
    private BillStatus status;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(nullable = false, name = "schedule_id")
    private Schedule schedule;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @CreatedDate
    private LocalDateTime paymentTime;
    private String paymentId;
    private String payerID;
}
