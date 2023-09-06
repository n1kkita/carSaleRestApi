package com.myfirstwebsocketapp.app.services;

import com.myfirstwebsocketapp.app.entity.Seller;

public interface SellerService extends BasicService< Seller, Seller > {
    Seller updateById(Long id, String role, Integer age);
}
