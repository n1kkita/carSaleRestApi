package com.CarSaleApi.app.services;

import com.CarSaleApi.app.dto.CarDto;
import com.CarSaleApi.app.entity.Car;

public interface CarService extends BasicService< Car, CarDto >, DtoService<CarDto>{
    CarDto updateById(Long id, Double newPrice);
}
