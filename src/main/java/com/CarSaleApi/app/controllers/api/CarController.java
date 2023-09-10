package com.CarSaleApi.app.controllers.api;

import com.CarSaleApi.app.dto.CarDto;
import com.CarSaleApi.app.entity.Car;
import com.CarSaleApi.app.services.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Car createCar(@RequestBody CarDto carDto){
        return carService.save(carDto);
    }
    @GetMapping
    public List< CarDto > getAllCars(){
        return carService.getAll();
    }
    @GetMapping("/{id}")
    public CarDto getCarById(@PathVariable Long id){
        return carService.getById(id);
    }

    @PatchMapping("/{id}")
    public CarDto updatePriceCarById(@PathVariable Long id,@RequestParam Double newPrice){
        return carService.updateById(id,newPrice);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCarById(@PathVariable Long id){
        carService.deleteById(id);
    }
}
