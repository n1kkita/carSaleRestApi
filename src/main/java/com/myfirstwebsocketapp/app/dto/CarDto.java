package com.myfirstwebsocketapp.app.dto;

import com.myfirstwebsocketapp.app.entity.Car;


public record CarDto
        (
        Long id,
        String mark,
        String model,
        Integer year,
        Double price,
        Car.Type type,
        Long carShowroomId
        )
{
}
