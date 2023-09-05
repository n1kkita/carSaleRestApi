package com.myfirstwebsocketapp.app.services;

import com.myfirstwebsocketapp.app.dto.CarDto;
import com.myfirstwebsocketapp.app.entity.Car;

public interface CarService {
    Car save(CarDto carDto);
}
