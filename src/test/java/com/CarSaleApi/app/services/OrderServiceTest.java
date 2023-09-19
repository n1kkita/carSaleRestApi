package com.CarSaleApi.app.services;

import com.CarSaleApi.app.dto.SellerDto;
import com.CarSaleApi.app.entity.Car;
import com.CarSaleApi.app.entity.Orders;
import com.CarSaleApi.app.entity.Seller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class OrderServiceTest {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CarService carService;
    @Autowired
    private SellerService sellerService;
    @Autowired
    @Qualifier("carTestBean")
    private Car carTest;
    @Autowired
    @Qualifier(value = "sellerTestBean")
    private Seller sellerTest;

    @Test
    @Order(1)
    @DisplayName("Sale car")
    @Transactional
    void saleCarTest(){
        sellerTest.setSales(new ArrayList<>());
        int leftInStockBeforeSaleCar = carTest.getLeftInStock();

        Orders testOrder = orderService.carSaleByIdAndSellerId(carTest.getId(),sellerTest.getId());
        int leftInStockAfterSaleCar = carService.getById(carTest.getId()).leftInStock();
        SellerDto seller = sellerService.getById(sellerTest.getId());

        assertNotNull(testOrder);
        assertEquals(leftInStockBeforeSaleCar-1,leftInStockAfterSaleCar);
        assertEquals(60, seller.salesBonusesForCurrentMonth());
        assertEquals(1,seller.numberOfCarsSold());
    }
}
