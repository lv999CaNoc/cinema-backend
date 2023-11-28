package com.example.cinema.pojo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;


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
    private Theater theater;

    @OneToMany(mappedBy = "room")
    @JsonManagedReference
    private List<Schedule> schedules;

    @OneToMany(mappedBy = "room")
    @JsonManagedReference
    List<Seat> seats;
}
