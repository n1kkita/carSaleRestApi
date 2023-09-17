package com.CarSaleApi.app.components.imp;

import com.CarSaleApi.app.components.Calculator;
import com.CarSaleApi.app.entity.Seller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@PropertySource("classpath:seller.properties")
public class CalculatorBonusesForSeller implements Calculator< Seller > {

    @Value("${seller.bonuses.sale}")
    private Double BONUS_RATE;
    @Override
    public Double calculate(Seller seller) {
        return seller.getSales().stream()
                .filter(order->order.getDateOfSale().getYear()  == LocalDate.now().getYear())
                .filter(order->order.getDateOfSale().getMonth() == LocalDate.now().getMonth())
                .mapToDouble(order->order.getCar().getPrice() * BONUS_RATE )
                .sum();
    }
}
