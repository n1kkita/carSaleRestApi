package com.CarSaleApi.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties({"carShowroom"})
    @OneToMany(mappedBy = "carShowroom")
    private List<Car> cars = new ArrayList<>();

    @JsonIgnoreProperties(value = {"carShowroom","sales"})
    @OneToMany(mappedBy = "carShowroom")
    private List<Seller> sellers = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "carShowroom",cascade = CascadeType.ALL)
    private List<Revenue> revenues = new ArrayList<>();
}
