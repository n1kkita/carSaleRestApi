package com.CarSaleApi.app.services;

import com.CarSaleApi.app.entity.CarShowroom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CarShowroomServiceTest {
    @Autowired
    private CarShowroomService carShowroomService;

    @Autowired
    @Qualifier(value = "carShowroomTestBean")
    private CarShowroom carShowroomTest;

    @Test
    @Order(1)
    @DisplayName("Get carshowroom by id")
    void getCarShowroomById(){
        assertNotNull(carShowroomService.getById(carShowroomTest.getId()));
    }
}
