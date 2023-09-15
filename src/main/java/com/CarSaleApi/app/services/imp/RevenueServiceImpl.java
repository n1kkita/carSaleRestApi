package com.CarSaleApi.app.services.imp;

import com.CarSaleApi.app.dto.RevenueDto;
import com.CarSaleApi.app.entity.Revenue;
import com.CarSaleApi.app.repositories.RevenueRepository;
import com.CarSaleApi.app.services.RevenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class RevenueServiceImpl implements RevenueService {

    private final RevenueRepository revenueRepository;
    @Override
    public RevenueDto getRevenueByDay(Date date) {
        return revenueRepository.findByRevenueDate(date)
                .map(revenue ->
                        new RevenueDto(revenue.getAmountOfRevenue(),
                        new SimpleDateFormat("yyyy-MM-dd").format(date))
                ).orElseThrow();
    }

    @Override
    public RevenueDto getRevenueByWeek(Date date1, Date date2) {
         int weeklyRevenueAmount = revenueRepository.findByWeek(date1,date2)
                .stream()
                .mapToInt(Revenue::getAmountOfRevenue)
                .sum();

        String startDate = new SimpleDateFormat("yyyy-MM-dd").format(date1);
        String endDate = new SimpleDateFormat("yyyy-MM-dd").format(date2);
        return new RevenueDto(weeklyRevenueAmount,startDate + "---" + endDate);
    }

    @Override
    public RevenueDto getRevenueByMonth(String month,String year) {
        int monthRevenueAmount = revenueRepository.findByMonth(month,year)
                .stream()
                .mapToInt(Revenue::getAmountOfRevenue)
                .sum();

        return new RevenueDto(monthRevenueAmount, year + "-" + month);
    }
}
