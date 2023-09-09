package com.myfirstwebsocketapp.app.services.imp;

import com.myfirstwebsocketapp.app.dto.CarDto;
import com.myfirstwebsocketapp.app.entity.Car;
import com.myfirstwebsocketapp.app.exceptions.CarNotFoundException;
import com.myfirstwebsocketapp.app.exceptions.MachinesOutOfStockException;
import com.myfirstwebsocketapp.app.repositories.CarRepository;
import com.myfirstwebsocketapp.app.services.CarService;
import com.myfirstwebsocketapp.app.services.CarShowroomService;
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

    private final CarShowroomService carShowroomService;
    @Override
    @Transactional
    @SneakyThrows
    public Car save(CarDto carDto) {

        Optional< Car > carOptional = carRepository.findCarByCarDto(
                carDto.mark(),
                carDto.model(),
                carDto.type(),
                carDto.price(),
                carDto.year()
        );

        if(carOptional.isPresent()){
            log.info("car " + carOptional.get() +" has already have so change quantity" );
            carOptional.get().setLeftInStock(carOptional.get().getLeftInStock()+1);
            return carOptional.get();
        } else {
            Car saveCar = CarDto.replaceToCarByCarDto(carDto,carShowroomService.getById(carDto.carShowroomDto().id()));
            log.info("new car " + saveCar + " was saved");
            return carRepository.save(saveCar);
        }
    }

    @Override
    @Transactional
    public CarDto updateById(Long id, Double newPrice) {
        Car car = carRepository.findById(id)
                .orElseThrow(CarNotFoundException :: new);
        car.setPrice(newPrice);
        return CarDto.replaceToDtoByCar(car);
    }

    @Override
    @Transactional
    public void deleteById(Long id){
        Car car = carRepository.findById(id)
                .orElseThrow(CarNotFoundException :: new);

        if(car.getLeftInStock() == 0) {
            throw new MachinesOutOfStockException();
        }
        car.setLeftInStock(car.getLeftInStock() - 1);

    }

    @Override
    @Transactional(readOnly = true)
    public List< CarDto > getAll() {
        return carRepository.findAll()
                .stream()
                .map(CarDto :: replaceToDtoByCar)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CarDto getById(Long id) {
        return carRepository.findById(id)
                .map(CarDto :: replaceToDtoByCar)
                .orElseThrow(CarNotFoundException :: new);
    }
}
