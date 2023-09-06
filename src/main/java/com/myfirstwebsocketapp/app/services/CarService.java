package com.myfirstwebsocketapp.app.services;

import com.myfirstwebsocketapp.app.dto.CarDto;
import com.myfirstwebsocketapp.app.entity.Car;

import java.util.List;

public interface CarService extends CrudService<Car, CarDto>{
    @Override
    Car save(CarDto t);

    @Override
    List< CarDto > getAll();

    @Override
    CarDto getById(Long id);

    @Override
    Car updateById(Long id);

    @Override
    void deleteById(Long id);
}
