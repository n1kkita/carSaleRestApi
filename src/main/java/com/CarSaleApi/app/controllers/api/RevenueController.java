package com.CarSaleApi.app.controllers.api;

import com.CarSaleApi.app.dto.RevenueDto;
import com.CarSaleApi.app.services.RevenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/revenues")
@RequiredArgsConstructor
public class RevenueController {

    private final RevenueService revenueService;

    @GetMapping("/day/{date}")
    public RevenueDto getRevenueByDay(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return revenueService.getRevenueByDay(date);
    }

    @GetMapping("/week/{startDate}/{endDate}")
    public RevenueDto getRevenueByDay(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                   @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return revenueService.getRevenueByWeek(startDate,endDate);
    }

    @GetMapping("/years/month/{year}/{month}")
    public RevenueDto getRevenueByMonth(@PathVariable String month,@PathVariable String year){
        return revenueService.getRevenueByMonth(month,year);
    }
}
