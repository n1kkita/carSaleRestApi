package com.CarSaleApi.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(
        indexes = @Index(name = "car_shoow_room_seller_indx",columnList = "carshowroom_id")
)
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
    private Integer numberOfCarsSold;
    private Double salesBonusesForCurrentMonth;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role = Role.SELLER;

    public enum Role{
        SELLER,
        MANAGER
    }
    @JsonIgnoreProperties({"sellers","cars"})
    @ManyToOne
    @JoinColumn(name = "carshowroom_id",
            foreignKey =@ForeignKey(name = "car_shoow_room_seller_fk")
    )
    private CarShowroom carShowroom;

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

    @PrePersist
    public void init(){
        numberOfCarsSold = 0;
    }
}
