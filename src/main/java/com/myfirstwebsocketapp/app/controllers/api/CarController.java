package com.myfirstwebsocketapp.app.controllers.api;

import com.myfirstwebsocketapp.app.entity.Car;
import com.myfirstwebsocketapp.app.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    @GetMapping
    public List< Car > getAllCars(){

    }
    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id){

    }

    @PostMapping
    public Car createCar(){

    }

}
