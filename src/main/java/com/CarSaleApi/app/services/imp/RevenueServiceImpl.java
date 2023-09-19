package com.CarSaleApi.app.services.imp;

import com.CarSaleApi.app.dto.RevenueDto;
import com.CarSaleApi.app.entity.Revenue;
import com.CarSaleApi.app.repositories.RevenueRepository;
import com.CarSaleApi.app.services.RevenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class RevenueServiceImpl implements RevenueService {

    private final RevenueRepository revenueRepository;
    @Override
    public RevenueDto getRevenueByDay(LocalDate date,Long idCarshowroom) {
        Revenue revenue = revenueRepository.findByRevenueDateAndCarShowroomId(date,idCarshowroom)
                .orElse(new Revenue(null,0,date,null));

        int dayRevenueAmount = revenue.getAmountOfRevenue();

        return new RevenueDto(dayRevenueAmount, date.toString());
    }
    @Override
    public RevenueDto getRevenueByWeek(LocalDate date1, LocalDate date2, Long idCarshowroom) {
         int weeklyRevenueAmount = revenueRepository.findByWeek(date1,date2,idCarshowroom)
                .stream()
                .mapToInt(Revenue::getAmountOfRevenue)
                .sum();

        String startDate = date1.toString();
        String endDate = date2.toString();
        return new RevenueDto(weeklyRevenueAmount,startDate + " --- " + endDate);
    }

    @Override
    public RevenueDto getRevenueByMonth(String month,String year,Long idCarshowroom) {
        int monthRevenueAmount = revenueRepository.findByMonth(month,year,idCarshowroom)
                .stream()
                .mapToInt(Revenue::getAmountOfRevenue)
                .sum();

        return new RevenueDto(monthRevenueAmount, year + "-" + month);
    }
}
