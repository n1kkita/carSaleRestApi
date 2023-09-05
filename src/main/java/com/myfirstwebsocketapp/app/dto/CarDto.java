package com.myfirstwebsocketapp.app.dto;

import com.myfirstwebsocketapp.app.entity.Car;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {
    private String mark;
    private String model;
    private Integer year;
    private Double price;
    private Car.Type type;
}
