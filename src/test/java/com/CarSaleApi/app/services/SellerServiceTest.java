package com.CarSaleApi.app.services;

import com.CarSaleApi.app.dto.CarShowroomDto;
import com.CarSaleApi.app.dto.SellerDto;
import com.CarSaleApi.app.entity.Seller;
import com.CarSaleApi.app.exceptions.SellerNotFoundException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SellerServiceTest {
    @Autowired
    private SellerService sellerService;

    private Seller sellerTest;
    @BeforeEach
    void setup(){
        SellerDto sellerDtoTest = new SellerDto(
                null,
                38,
                "Vasily",
                "Vanko",
                0,
                Seller.Role.SELLER,
                new CarShowroomDto(1L, "KARTEK-AUTO"),
                null
        );
        sellerTest = sellerService.save(sellerDtoTest);
    }
    @AfterEach
    void clean(){
        sellerService.deleteById(sellerTest.getId());
    }

    @Test
    @Order(1)
    @DisplayName("Get seller by id")
    void getSellerById() {
        assertNotNull(sellerService.getById(sellerTest.getId()));
    }

    @Test
    @Order(2)
    @DisplayName("Get seller by id throw SellerNotFoundException")
    void getSellerByIdThrowSellerNotFoundException(){
        assertThrows(SellerNotFoundException.class,
                ()->sellerService.getById(1000000000000L));
    }

    @Test
    @Order(3)
    @DisplayName("Get all sellers")
    void getAllSellers(){
        assertNotNull(sellerService.getAll());
    }

    @Test
    @Order(4)
    @DisplayName("Update seller by id")
    @Transactional
    void updateSeller(){
        sellerTest.setSales(new ArrayList<>());
        sellerService.updateById(sellerTest.getId(), String.valueOf(Seller.Role.MANAGER),99);
    }


}
