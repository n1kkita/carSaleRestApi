package com.myfirstwebsocketapp.app.services.imp;

import com.myfirstwebsocketapp.app.dto.CarDto;
import com.myfirstwebsocketapp.app.entity.Car;
import com.myfirstwebsocketapp.app.repositories.CarRepository;
import com.myfirstwebsocketapp.app.services.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    @Override
    public Car save(CarDto carDto) {
        return null;
    }
}
