package com.CarSaleApi.app.dto;

import com.CarSaleApi.app.entity.Car;
import com.CarSaleApi.app.entity.CarShowroom;


public record CarDto(
        Long id,
        Integer leftInStock,
        String mark,
        String model,
        Integer year,
        Double price,
        Car.Type type,
        CarShowroomDto carShowroomDto
)
{
    public static CarDto replaceToDtoByCar(Car car){
        return new CarDto(
                car.getId(),
                car.getLeftInStock(),
                car.getMark(),
                car.getModel(),
                car.getYear(),
                car.getPrice(),
                car.getType(),
                new CarShowroomDto(car.getCarShowroom().getId(),car.getCarShowroom().getName()));
    }

    public static Car replaceToCarByCarDto(CarDto carDto, CarShowroom carShowroom){
        return Car.
                builder()
                .mark(carDto.mark())
                .model(carDto.model())
                .price(carDto.price())
                .type(carDto.type())
                .year(carDto.year())
                .carShowroom(carShowroom)
                .build();
    }
}
