package com.myfirstwebsocketapp.app.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private String mark;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;
    public enum Type{
        PASSENGER_CAR,
        FREIGHTER_CAR,
        SPORT_CAR
    }

    @OneToMany(mappedBy = "car")
    private List<Order> sales = new ArrayList<>();
}
