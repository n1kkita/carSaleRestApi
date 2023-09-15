package com.CarSaleApi.app.controllers.api;

import com.CarSaleApi.app.dto.RevenueDto;
import com.CarSaleApi.app.services.RevenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/revenues")
@RequiredArgsConstructor
public class RevenueController {

    private final RevenueService revenueService;

    @GetMapping("/day/{date}")
    public RevenueDto getRevenueByDay(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return revenueService.getRevenueByDay(date);
    }

    @GetMapping("/week/{startDate}/{endDate}")
    public RevenueDto getRevenueByDay(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                   @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        return revenueService.getRevenueByWeek(startDate,endDate);
    }

    @GetMapping("/years/month/{year}/{month}")
    public RevenueDto getRevenueByMonth(@PathVariable String month,@PathVariable String year){
        return revenueService.getRevenueByMonth(month,year);
    }
}
