package com.CarSaleApi.app.repositories;

import com.CarSaleApi.app.entity.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface RevenueRepository extends JpaRepository< Revenue,Long > {
    Optional<Revenue> findByRevenueDate(Date date);
}
