package com.myfirstwebsocketapp.app.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime dateOfSale = LocalDateTime.now();
    @ManyToOne(optional = false)
    @JoinColumn(name = "salesman_id")
    private Salesman salesman;

    @ManyToOne(optional = false)
    @JoinColumn(name = "car_id")
    private Car car;

}
