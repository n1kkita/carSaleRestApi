package com.CarSaleApi.app.services;


import com.CarSaleApi.app.dto.CarDto;
import com.CarSaleApi.app.dto.CarShowroomDto;
import com.CarSaleApi.app.entity.Car;
import com.CarSaleApi.app.exceptions.CarNotFoundException;
import com.CarSaleApi.app.exceptions.MachinesOutOfStockException;
import com.CarSaleApi.app.repositories.CarRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
class CarServiceTest {

    @Autowired
    private CarService carService;
    @Autowired
    private CarRepository  carRepository;
    private Car testCar;
    @BeforeEach
    void setup(){

        CarDto carDtoCreateTest = new CarDto(
                null,
                null,
                "Volvo",
                "S3 turbo",
                2022,
                12000.0,
                Car.Type.SPORT_CAR,
                new CarShowroomDto(1L, "KARTEK-AUTO")
        );

        testCar = carService.save(carDtoCreateTest);
    }
    @AfterEach
    void clean(){
        carRepository.deleteById(testCar.getId());
    }
    @Test
    @Order(1)
    @DisplayName("Getting car by id throw CarNotFoundException")
    void getCarByIdThrowsCarNotFoundException(){
        Assertions.assertThrows(CarNotFoundException.class,
                ()->carService.getById(10000000000L));
    }
    @Test
    @Order(2)
    @DisplayName("Getting car by id")
    void getCarById() {
        Assertions.assertNotNull(carService.getById(testCar.getId()));
    }

    @Test
    @Order(3)
    @DisplayName("Getting all cars")
    void getAllCars(){
        Assertions.assertNotNull(carService.getAll());
    }

    @Test
    @Order(4)
    @DisplayName("Delete car by id")
    void deleteCarById(){
        carService.deleteById(testCar.getId());
    }

    @Test
    @Order(5)
    @DisplayName("Delete car by id throw MachinesOutOfStockException")
    void deleteCarByIdMachinesOutOfStockException(){
        carService.deleteById(testCar.getId());
        Assertions.assertThrows(MachinesOutOfStockException.class,
                ()->carService.deleteById(testCar.getId()));
    }
    @Test
    @Order(6)
    @DisplayName("Update car by id")
    @Transactional
    void updateCarById(){
        carService.updateById(testCar.getId(),13000.0);
        Assertions.assertEquals(13000.0,testCar.getPrice());
    }
}
