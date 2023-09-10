package com.CarSaleApi.app.repositories;

import com.CarSaleApi.app.entity.CarShowroom;

import java.util.Optional;

public interface CustomRepository {
    Optional< CarShowroom > findCarShowroomFetchCarsAndSellersById(Long id);
}
