package com.myfirstwebsocketapp.app.services;

import com.myfirstwebsocketapp.app.entity.Orders;

public interface OrderService {
    Orders getById(Long id);
    Orders carSaleByIdAndSellerId(Long carId,Long sellerId);
}
