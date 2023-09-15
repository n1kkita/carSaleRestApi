package com.CarSaleApi.app.services;

import com.CarSaleApi.app.dto.RevenueDto;

import java.time.LocalDate;
import java.util.Date;

public interface RevenueService {
    RevenueDto getRevenueByDay(LocalDate date);
    RevenueDto getRevenueByWeek(LocalDate date1,LocalDate date2);

    RevenueDto getRevenueByMonth(String month,String year);

}
