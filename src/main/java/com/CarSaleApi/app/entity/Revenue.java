package com.CarSaleApi.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(indexes =  @Index(name = "revenueDate_indx",columnList = "revenueDate"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Revenue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer amountOfRevenue;
    @Column(nullable = false, columnDefinition = "DATE")
    @Temporal(TemporalType.DATE)
    private LocalDate revenueDate;
    @ManyToOne
    @JoinColumn(
            name = "carshowroom_id",
            foreignKey = @ForeignKey(name = "car_show_room_revenue_fk"),
            nullable = false
    )
    private CarShowroom carShowroom;

}
