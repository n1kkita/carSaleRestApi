package com.myfirstwebsocketapp.app.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(indexes = {
        @Index(name = "order_salesman_indx",columnList = "salesman_id"),
        @Index(name = "order_car_indx",columnList = "car_id")
})
@Getter
@Setter
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime dateOfSale;

    @JsonIgnoreProperties({"sales"}) // Игнорируем поле sales при выгрузке Seller
    @ManyToOne(optional = false)
    @JoinColumn(
            name = "salesman_id",
            foreignKey = @ForeignKey(name = "order_salesman_fkey"),
            nullable = false
    )
    private Seller seller;

    @JsonIgnoreProperties({"carShowroom"})
    @ManyToOne(optional = false)
    @JoinColumn(
            name = "car_id",
            foreignKey = @ForeignKey(name = "order_car_fkey"),
            nullable = false
    )
    private Car car;
    @PrePersist
    public void init(){
        dateOfSale = LocalDateTime.now();
    }

}
