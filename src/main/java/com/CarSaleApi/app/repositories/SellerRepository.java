package com.CarSaleApi.app.repositories;

import com.CarSaleApi.app.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SellerRepository extends JpaRepository< Seller,Long > {
    @Override
    @Query("select s from Seller s left join fetch s.sales left join fetch s.carShowroom")
    List< Seller > findAll();
}
