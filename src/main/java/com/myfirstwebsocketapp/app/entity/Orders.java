package com.myfirstwebsocketapp.app.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(indexes = {
        @Index(name = "order_salesman_indx",columnList = "salesman_id"),
        @Index(name = "order_car_indx",columnList = "car_id")
})
@Getter
@Setter
@EqualsAndHashCode
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime dateOfSale = LocalDateTime.now();
    @ManyToOne(optional = false)
    @JoinColumn(
            name = "salesman_id",
            foreignKey = @ForeignKey(name = "order_salesman_fkey"),
            nullable = false
    )
    private Seller seller;

    @ManyToOne(optional = false)
    @JoinColumn(
            name = "car_id",
            foreignKey = @ForeignKey(name = "order_car_fkey"),
            nullable = false
    )
    private Car car;

}
