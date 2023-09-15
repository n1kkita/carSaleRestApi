package com.CarSaleApi.app.services;

import com.CarSaleApi.app.dto.RevenueDto;

import java.util.Date;

public interface RevenueService {
    RevenueDto getRevenueByDay(Date date);
    RevenueDto getRevenueByWeek(Date date1,Date date2);

    RevenueDto getRevenueByMonth(String month,String year);

}
