package com.CarSaleApi.app.controllers.api;

import com.CarSaleApi.app.dto.CarShowroomDto;
import com.CarSaleApi.app.entity.CarShowroom;
import com.CarSaleApi.app.services.CarShowroomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/car-showrooms")
@RequiredArgsConstructor
public class CarShowroomController {
    private final CarShowroomService carShowroomService;

    @GetMapping("/{id}")
    public CarShowroom getCarShowroomById(@PathVariable Long id){
        return carShowroomService.getById(id);
    }

    @PostMapping
    public CarShowroom createCar(@RequestBody CarShowroomDto carShowroomDto){
        return carShowroomService.save(carShowroomDto);
    }

}
