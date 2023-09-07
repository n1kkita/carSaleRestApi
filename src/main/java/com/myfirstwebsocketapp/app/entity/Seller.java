package com.myfirstwebsocketapp.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table
@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private Integer numberOfCarsSold = 0;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role = Role.SELLER;

    public enum Role{
        SELLER,
        MANAGER
    }

    @JsonIgnoreProperties({"seller"})
    @OneToMany(mappedBy = "seller")
    private List< Orders > sales = new ArrayList<>();

    public Orders saleCar(Car car){
        numberOfCarsSold++;
        Orders order = Orders.builder()
                .car(car)
                .seller(this)
                .build();
        sales.add(order);

        return order;
    }

}
