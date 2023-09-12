package com.CarSaleApi.app.services;


import com.CarSaleApi.app.config.ConfigTestBean;
import com.CarSaleApi.app.entity.Car;
import com.CarSaleApi.app.exceptions.CarNotFoundException;
import com.CarSaleApi.app.exceptions.MachinesOutOfStockException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration(classes = {ConfigTestBean.class})
class CarServiceTest {
    @Autowired
    private CarService carService;
    @Autowired
    @Qualifier("carTestBean")
    private Car carTest;
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
        Assertions.assertNotNull(carService.getById(carTest.getId()));
    }

    @Test
    @Order(3)
    @DisplayName("Getting all cars")
    void getAllCars(){
        Assertions.assertNotNull(carService.getAll());
    }

    @Test
    @Order(4)
    @DisplayName("Update car by id")
    @Transactional
    void updateCarById(){
        Assertions.assertEquals(
                13000.0,
                        carService.updateById(carTest.getId(),13000.0).price());
    }
    @Test
    @Order(5)
    @DisplayName("Delete car by id")
    void deleteCarById(){
        int initialQuantity = carTest.getLeftInStock();
        int afterRemoval = initialQuantity-1;
        carService.deleteById(carTest.getId());
        assertEquals(afterRemoval,
                carService.getById(carTest.getId()).leftInStock());
    }

    @Test
    @Order(6)
    @DisplayName("Delete car by id throw MachinesOutOfStockException")
    void deleteCarByIdMachinesOutOfStockException(){
        Assertions.assertThrows(MachinesOutOfStockException.class,
                ()->carService.deleteById(carTest.getId()));
    }

}
