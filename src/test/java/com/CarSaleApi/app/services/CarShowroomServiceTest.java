package com.CarSaleApi.app.services;

import com.CarSaleApi.app.dto.CarShowroomDto;
import com.CarSaleApi.app.entity.CarShowroom;
import com.CarSaleApi.app.repositories.CarShowroomRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarShowroomServiceTest {
    @Autowired
    private CarShowroomService carShowroomService;
    @Autowired
    private CarShowroomRepository carShowroomRepository;
    private CarShowroom carShowroomTest;
    @BeforeEach
    void setup(){
        carShowroomTest = carShowroomService.save(
                new CarShowroomDto(null,"TestCarShowroom")
        );
    }

    @AfterEach
    void clean(){
        carShowroomRepository.deleteById(carShowroomTest.getId());
    }

    @Test
    @Order(1)
    @DisplayName("Get carshowroom by id")
    void getCarShowroomById(){
        System.out.println(carShowroomTest.getId());
        assertNotNull(carShowroomService.getById(carShowroomTest.getId()));
    }
}
