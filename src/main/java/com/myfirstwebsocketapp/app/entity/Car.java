package com.myfirstwebsocketapp.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode(exclude = {"id","quantity","sales"})
@ToString(exclude = {"sales"})
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer quantity = 1;

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
    @JsonIgnore
    @OneToMany(mappedBy = "car")
    private List< Orders > sales = new ArrayList<>();
}
