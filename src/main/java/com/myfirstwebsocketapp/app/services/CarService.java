package com.myfirstwebsocketapp.app.services;

import com.myfirstwebsocketapp.app.dto.CarDto;
import com.myfirstwebsocketapp.app.entity.Car;

import java.util.List;

public interface CarService extends BasicService<Car, CarDto>, DtoService<CarDto>{
    Car updateById(Long id, Double newPrice);
}
