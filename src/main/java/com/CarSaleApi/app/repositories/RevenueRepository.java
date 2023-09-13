package com.CarSaleApi.app.repositories;

import com.CarSaleApi.app.entity.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RevenueRepository extends JpaRepository< Revenue,Long > {
}
