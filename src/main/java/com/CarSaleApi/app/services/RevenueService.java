package com.CarSaleApi.app.services;

import com.CarSaleApi.app.entity.Revenue;

import java.util.Date;

public interface RevenueService {
    Revenue getRevenueByDay(Date date);
    Revenue getRevenueByWeek(Date date1,Date date2);

    Revenue getRevenueByMonth(String nameMonth);

}
