package com.CarSaleApi.app.services;

import com.CarSaleApi.app.config.ConfigTestBean;
import com.CarSaleApi.app.dto.RevenueDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;

@SpringBootTest
@ContextConfiguration(classes = {ConfigTestBean.class})
class RevenueServiceTest {

    @Autowired
    private RevenueService revenueService;

    @Test
    public void getRevenueByDay(){
        RevenueDto revenueByDay1 = revenueService.getRevenueByDay(LocalDate.of(2023, 11, 25));
        RevenueDto revenueByDay2 = revenueService.getRevenueByDay(LocalDate.of(2023, 11, 26));


        Assertions.assertEquals(15000,revenueByDay1.amountOfRevenue());
        Assertions.assertEquals(10000,revenueByDay2.amountOfRevenue());
    }

    @Test
    public void getRevenueByWeek(){
        RevenueDto revenueByWeek = revenueService.getRevenueByWeek(
                LocalDate.of(2023,11,25),
                LocalDate.of(2023,11,30)
        );

        Assertions.assertEquals(78000,revenueByWeek.amountOfRevenue());
    }

    @Test
    public void getRevenueByMonth(){
        RevenueDto revenueByWeek = revenueService.getRevenueByMonth("1","2024");
        Assertions.assertEquals(182000,revenueByWeek.amountOfRevenue());
    }
}
