package com.myfirstwebsocketapp.app.repositories;

import com.myfirstwebsocketapp.app.entity.CarShowroom;

import java.util.Optional;

public interface CustomRepository {
    Optional< CarShowroom > findCarShowroomFetchCarsAndSellersById(Long id);
}
