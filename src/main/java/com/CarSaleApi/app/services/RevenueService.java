package com.CarSaleApi.app.services;

import com.CarSaleApi.app.dto.RevenueDto;

import java.time.LocalDate;

public interface RevenueService {
    RevenueDto getRevenueByDay(LocalDate date,Long idCarshowroom);
    RevenueDto getRevenueByWeek(LocalDate date1,LocalDate date2,Long idCarshowroom);

    RevenueDto getRevenueByMonth(String month,String year,Long idCarshowroom);

}
