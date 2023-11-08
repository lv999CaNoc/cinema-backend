package com.example.cinema.pojo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Data
@Table(name="rooms")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer capacity;

    @ManyToOne
    @JoinColumn(nullable = false, name = "theater_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Theaters theater;
}
