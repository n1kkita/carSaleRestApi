package com.CarSaleApi.app.components.imp;

import com.CarSaleApi.app.components.Calculator;
import com.CarSaleApi.app.entity.Seller;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CalculatorBonusesForSeller implements Calculator< Seller > {
    @Override
    public Double calculate(Seller seller) {
        return seller.getSales().stream()
                .filter(order->order.getDateOfSale().getYear()  == LocalDate.now().getYear())
                .filter(order->order.getDateOfSale().getMonth() == LocalDate.now().getMonth())
                .mapToDouble(order->order.getCar().getPrice()*0.05)
                .sum();
    }
}
