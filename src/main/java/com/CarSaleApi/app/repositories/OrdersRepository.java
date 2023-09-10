package com.CarSaleApi.app.repositories;

import com.CarSaleApi.app.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersRepository extends JpaRepository< Orders,Long> {
    @Override
    @Query("select o from Orders o left join fetch o.car left join fetch o.seller")
    List< Orders > findAll();
}
