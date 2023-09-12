package com.CarSaleApi.app.services;

import com.CarSaleApi.app.dto.SellerDto;
import com.CarSaleApi.app.entity.Seller;
import com.CarSaleApi.app.exceptions.SellerNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SellerServiceTest {
    @Autowired
    private SellerService sellerService;
    @Autowired
    @Qualifier(value = "sellerTestBean")
    private Seller sellerTest;

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
    void updateSeller(){
        sellerTest.setSales(new ArrayList<>());

        SellerDto updateSellerDto = sellerService.updateById(sellerTest.getId(),
                String.valueOf(Seller.Role.MANAGER),99);


        assertEquals(99,updateSellerDto.age());
        assertEquals(Seller.Role.MANAGER,updateSellerDto.role());
    }


}
