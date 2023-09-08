package com.myfirstwebsocketapp.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarShowroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "carShowroom")
    private List<Car> cars = new ArrayList<>();
    @OneToMany(mappedBy = "carShowroom")
    private List<Seller> sellers = new ArrayList<>();
}
