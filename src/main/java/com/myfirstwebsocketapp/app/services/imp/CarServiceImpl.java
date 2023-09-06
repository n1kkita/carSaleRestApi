package com.myfirstwebsocketapp.app.services.imp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myfirstwebsocketapp.app.dto.CarDto;
import com.myfirstwebsocketapp.app.entity.Car;
import com.myfirstwebsocketapp.app.repositories.CarRepository;
import com.myfirstwebsocketapp.app.services.CarService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final ObjectMapper objectMapper;
    @Override
    @Transactional
    @SneakyThrows
    public Car save(CarDto carDto) {
        String carDtoJson = objectMapper.writeValueAsString(carDto);

        Optional< Car > carOptional = carRepository.findCarByCarDto(
                carDto.getMark(),
                carDto.getModel(),
                carDto.getType(),
                carDto.getPrice(),
                carDto.getYear()
        );

        if(carOptional.isPresent()){
            log.info("car " + carOptional.get() +" has already have so change quantity" );
            carOptional.get().setQuantity(carOptional.get().getQuantity()+1);
            return carOptional.get();
        } else {
            Car saveCar = objectMapper.readValue(carDtoJson, Car.class);
            log.info("new car " + saveCar + " was saved");
            return carRepository.save(saveCar);
        }
    }

    @Override
    public Car updateById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List< CarDto > getAll() {
        return carRepository.findAllCar();
    }

    @Override
    public CarDto getById(Long id) {
        return carRepository.findCarById(id)
                .orElseThrow(()-> new EntityNotFoundException("Car not found"));
    }
}
