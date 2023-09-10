package com.CarSaleApi.app.services;

import com.CarSaleApi.app.dto.SellerDto;
import com.CarSaleApi.app.entity.Seller;

public interface SellerService extends BasicService< Seller, SellerDto >{

    SellerDto updateById(Long id, String role, Integer age);
}
