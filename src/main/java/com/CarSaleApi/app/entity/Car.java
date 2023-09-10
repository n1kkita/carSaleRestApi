package com.CarSaleApi.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        indexes = @Index(name = "carshowroom_car_indx",columnList = "carshowroom_id")
)
@Getter
@Setter
@Builder
@EqualsAndHashCode(exclude = {"id","leftInStock","sales"})
@ToString(exclude = {"sales"})
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer leftInStock;

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


    @JsonIgnoreProperties({"cars","sellers"})
    @ManyToOne
    @JoinColumn(name = "carshowroom_id",
            foreignKey = @ForeignKey(name = "car_shoow_romm_fk")
    )
    private CarShowroom carShowroom;

    @PrePersist
    public void init(){
         leftInStock = 1;
    }
}
