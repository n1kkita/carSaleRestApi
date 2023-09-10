package com.CarSaleApi.app.services;

import com.CarSaleApi.app.entity.Orders;

import java.util.List;

public interface OrderService {
    List< Orders > getAll();
    Orders getById(Long id);
    Orders carSaleByIdAndSellerId(Long carId,Long sellerId);
}
